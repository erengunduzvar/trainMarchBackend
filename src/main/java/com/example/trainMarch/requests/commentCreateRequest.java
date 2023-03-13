package com.example.trainMarch.requests;

import com.example.trainMarch.entities.comment;
import com.example.trainMarch.entities.post;
import com.example.trainMarch.entities.user;
import lombok.Data;

@Data
public class commentCreateRequest {
    Long id;
    Long postId;
    Long userId;
    String text;

    public comment toComment(user user, post post)
    {
        if(user.getId().equals(userId) && post.getId().equals(postId))
        {
            comment comment = new comment();
            comment.setId(this.id);
            comment.setText(this.text);
            comment.setUser(user);
            comment.setPost(post);
            return comment;
        }
        return null;
    }
}
