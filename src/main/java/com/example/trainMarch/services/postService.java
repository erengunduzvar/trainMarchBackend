package com.example.trainMarch.services;
import com.example.trainMarch.entities.post;
import com.example.trainMarch.entities.user;
import com.example.trainMarch.repos.*;
import com.example.trainMarch.requests.postCreateRequest;
import com.example.trainMarch.requests.postUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class postService {
    private postRepository postRepository;
    private userService userService;

    public postService(postRepository postRepository,userService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<post> getAllPosts(Optional<Long> userId) {
        //Eğer request paramla user id parametresi gönderilmiş ise sadece o user'ın postlarını döndür
        if(userId.isPresent())
        {
            return postRepository.findByUserId(userId.get());

        }
        //Tüm postları döndür.
        else
        {
            return postRepository.findAll();
        }
    }

    public post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }


    public post saveOnePost(postCreateRequest postCreateRequest) {
        user foundUser = userService.getUserById(postCreateRequest.getUserId());
        if(foundUser == null)
            return null;

        return postRepository.save(postCreateRequest.toPost(foundUser));


    }

    public post updateOnePost(Long postId, postUpdateRequest postUpdateRequest) {
        Optional<post> foundPost = postRepository.findById(postId);
        if(foundPost.isEmpty())
            return null;

        post newPost = foundPost.get();
        newPost.setText(postUpdateRequest.getText());
        newPost.setTitle(postUpdateRequest.getTitle());

        postRepository.save(newPost);
        return newPost;
    }

    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
