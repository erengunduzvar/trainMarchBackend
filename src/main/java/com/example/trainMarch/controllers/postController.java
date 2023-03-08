package com.example.trainMarch.controllers;

import com.example.trainMarch.entities.post;
import com.example.trainMarch.entities.user;
import com.example.trainMarch.requests.postCreateRequest;
import org.springframework.web.bind.annotation.*;
import com.example.trainMarch.services.postService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class postController {
    private postService postService;

    public postController(com.example.trainMarch.services.postService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<post> getAllPosts(@RequestParam Optional<Long> userId)
    {
        return postService.getAllPosts(userId);
    }
    @GetMapping("/{postId}")
    public post getPostById(@PathVariable Long postId)
    {
        return postService.getPostById(postId);
    }
    @PostMapping
    public post saveOnePost(@RequestBody postCreateRequest postCreateRequest)
    {
        return postService.saveOnePost(postCreateRequest);
    }


}
