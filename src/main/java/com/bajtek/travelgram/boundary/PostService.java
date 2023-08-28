package com.bajtek.travelgram.boundary;

import com.bajtek.travelgram.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void save(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAllPostsSortedByCreatedDesc() {
        return postRepository.findAllByOrderByCreatedDesc();
    }
}
