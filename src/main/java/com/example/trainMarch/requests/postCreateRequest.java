package com.example.trainMarch.requests;

import com.example.trainMarch.entities.post;
import com.example.trainMarch.entities.user;
import lombok.Data;

@Data
public class postCreateRequest {
    Long id;
    String title;
    String text;
    Long userId;

    public post toPost(user user)
    {
        if(this.userId.equals(user.getId()))
        {
            post post = new post();
            post.setId(this.id);
            post.setText(this.text);
            post.setTitle(this.title);
            post.setUser(user);
            return post;
        }
        return null;

    }
}
