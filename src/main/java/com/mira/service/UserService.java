package com.mira.service;

import com.mira.document.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User getUser(String id);

    List<User> getAllUsers();

    User updateUser(User user);

    User createUser(User user);

    void deleteUser(UUID uuid);
}
