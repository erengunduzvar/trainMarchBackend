package com.example.trainMarch.services;
import com.example.trainMarch.entities.post;
import com.example.trainMarch.entities.user;
import com.example.trainMarch.repos.*;
import com.example.trainMarch.requests.postCreateRequest;
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



    }
}
