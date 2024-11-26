package com.crrm.controller;

import com.crrm.entity.Post;
import com.crrm.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @PostMapping
    public String createPost(
            @RequestBody Post post
    ){
        postRepository.save(post);
        return "Post created successfully";
    }
    @DeleteMapping
    public String deletePost()
    {
        postRepository.deleteById(1L);
        return "Post deleted successfully";
    }
}
