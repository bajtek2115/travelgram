package com.bajtek.travelgram.web;

import com.bajtek.travelgram.boundary.AuthenticationService;
import com.bajtek.travelgram.boundary.PostService;
import com.bajtek.travelgram.config.DictionaryMapper;
import com.bajtek.travelgram.entity.Country;
import com.bajtek.travelgram.entity.Post;
import com.bajtek.travelgram.entity.PostCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CreatePostController {

    @Autowired
    private PostService postService;

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/add-post", method = RequestMethod.GET)
    public String addPost(Model model) {
        model.addAttribute("post", new PostCreateRequest());
        model.addAttribute("countriesDict", dictionaryMapper.mapCountries(Country.values()));
        return "add-post";
    }

    @RequestMapping(value = "/add-post", method = RequestMethod.POST)
    public RedirectView createPostSubmit(@ModelAttribute(value = "post") PostCreateRequest postCreateRequest) {
        Post post = new Post();
        post.setUserId(authenticationService.getAuthenticatedUser().getId());
        post.setDescription(postCreateRequest.getDescription());
        post.setCreated(postCreateRequest.getCreated());
        post.setImage(postCreateRequest.getImage());
        post.setCountry(postCreateRequest.getCountry());
        postService.save(post);
        return new RedirectView("/");
    }
}