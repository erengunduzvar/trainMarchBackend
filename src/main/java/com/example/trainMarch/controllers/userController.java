package com.example.trainMarch.controllers;

import com.example.trainMarch.entities.user;
import org.springframework.web.bind.annotation.*;
import com.example.trainMarch.services.userService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class userController {

    private userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<user> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping
    public user createUser(@RequestBody user newUser)
    {
        return userService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public user getOneUser(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
    @PutMapping("/{userId}")
    public user uptadeOneUser(@PathVariable Long userId,@RequestBody user newUser)
    {
        return userService.updateUserById(userId,newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId)
    {
        userService.deleteUserById(userId);
    }

}
