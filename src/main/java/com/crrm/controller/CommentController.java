package com.crrm.controller;

import com.crrm.entity.Comments;
import com.crrm.entity.Post;
import com.crrm.repository.CommentRepository;
import com.crrm.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentController(PostRepository postRepository, CommentRepository commentRepository){
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
   @PostMapping
    public String createComment(
            @RequestBody Comments comments,
            @RequestParam long postId
    ){
        Post post = postRepository.findById(postId).get();
        comments.setPost(post);
        commentRepository.save(comments);
        return "Comment created successfully";
    }



}
