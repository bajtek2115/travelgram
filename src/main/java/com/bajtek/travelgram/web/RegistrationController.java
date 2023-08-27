package com.bajtek.travelgram.web;

import com.bajtek.travelgram.boundary.UserService;
import com.bajtek.travelgram.entity.User;
import com.bajtek.travelgram.entity.UserCreateRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("userCreateRequest", new UserCreateRequest());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RedirectView createUser(@Valid @ModelAttribute(value = "userCreateRequest") UserCreateRequest userCreateRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new RedirectView("/register");
        }
        User user = new User();
        user.setUsername(userCreateRequest.getUsername());
        user.setPassword(userCreateRequest.getPassword());
        try {
            userService.createUser(user);
        } catch (Exception e) {
            return new RedirectView("/");
        }
        return new RedirectView("/");
    }
}