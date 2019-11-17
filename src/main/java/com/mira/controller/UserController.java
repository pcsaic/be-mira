package com.mira.controller;

import com.mira.document.User;
import com.mira.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable (value = "id") UUID uuid){
        userService.deleteUser(uuid);
    }
}
