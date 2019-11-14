package com.mira.service;

import com.mira.document.User;

import java.util.List;

public interface UserService {

    User getUser(String id);

    List<User> getAllUsers();
}
