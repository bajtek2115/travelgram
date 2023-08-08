package com.bajtek.travelgram.web;

import com.bajtek.travelgram.boundary.PostService;
import com.bajtek.travelgram.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WallController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Post> posts = postService.getAllPostsSortedByCreatedDesc();
        model.addAttribute("posts", posts);
        return "index";
    }
}