package com.example.trainMarch.services;
import com.example.trainMarch.entities.comment;
import com.example.trainMarch.entities.post;
import com.example.trainMarch.entities.user;
import com.example.trainMarch.repos.commentRepository;
import com.example.trainMarch.requests.commentCreateRequest;
import com.example.trainMarch.requests.commentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class commentService {
    private commentRepository commentRepository;
    private userService userService;
    private postService postService;
    public commentService(commentRepository commentRepository, postService postService,userService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }



    public List<comment> getAllComments(Optional<Long> postId, Optional<Long> userId) {

        //comments?postId={postId}&userId={userId}
        if(postId.isPresent() && userId.isPresent())
        {
            return commentRepository.findByUserIdAndPostId(postId.get(),userId.get());
        }
        //comments?postId={postId}
        else if(postId.isPresent())
        {
            return commentRepository.findByPostId(postId.get());
        }
        //comments?userId={userId}
        else if(userId.isPresent())
        {
            return commentRepository.findByUserId(userId.get());
        }
        //comments
        else
        {
            return commentRepository.findAll();
        }
    }

    public comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public comment saveOneComment(commentCreateRequest commentCreateRequest) {
        user user = userService.getUserById(commentCreateRequest.getUserId());
        post post = postService.getPostById(commentCreateRequest.getPostId());

        if(user != null && post != null)
        {
            comment comment = commentCreateRequest.toComment(user,post);
            return commentRepository.save(comment);
        }
        return null;
    }

    public comment updateOneComment(Long commentId, commentUpdateRequest commentUpdateRequest) {
        Optional<comment> foundComment = commentRepository.findById(commentId);

        if(foundComment.isEmpty())
            return null;

        comment comment = foundComment.get();
        comment.setText(commentUpdateRequest.getText());

        commentRepository.save(comment);

        return comment;

    }

    public void deleteOneComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
