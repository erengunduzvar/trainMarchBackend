package com.example.trainMarch.services;

import com.example.trainMarch.entities.user;
import org.springframework.stereotype.Service;
import com.example.trainMarch.repos.userRepository;

import java.util.List;
import java.util.Optional;


@Service
public class userService {
    private userRepository userRepository;

    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    public user saveOneUser(user newUser) {
        return userRepository.save(newUser);
    }

    public user getUserById(Long userId) {
        //        custom expension
        return userRepository.findById(userId).orElse(null);
    }

    public user updateUserById(Long userId, user newUser) {

        Optional<user> user = userRepository.findById(userId);

        if(user.isPresent())
        {
            user foundUser = user.get();

            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }
        else
        {
            return null;
        }
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
