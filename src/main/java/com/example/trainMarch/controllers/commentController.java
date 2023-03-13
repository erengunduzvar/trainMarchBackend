package com.example.trainMarch.controllers;

import com.example.trainMarch.entities.comment;
import com.example.trainMarch.requests.commentCreateRequest;
import com.example.trainMarch.requests.commentUpdateRequest;
import org.springframework.web.bind.annotation.*;
import com.example.trainMarch.services.commentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class commentController {

    private commentService commentService;

    public commentController(commentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<comment> getAllComments(@RequestParam Optional<Long> postId, @RequestParam Optional<Long> userId)
    {
        return commentService.getAllComments(postId,userId);
    }
    @GetMapping("/{commentId}")
    public comment getCommentById(@PathVariable Long commentId)
    {
        return commentService.getOneCommentById(commentId);
    }
    @PostMapping
    public comment saveOneComment(@RequestBody commentCreateRequest commentCreateRequest)
    {
        return commentService.saveOneComment(commentCreateRequest);
    }
    @PutMapping("/{commentId}")
    public comment updateOneComment(@RequestBody commentUpdateRequest commentUpdateRequest, @PathVariable Long commentId)
    {
        return commentService.updateOneComment(commentId,commentUpdateRequest);
    }
    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId)
    {
        commentService.deleteOneComment(commentId);
    }
}
