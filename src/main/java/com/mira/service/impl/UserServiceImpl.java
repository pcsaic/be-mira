package com.mira.service.impl;

import com.mira.document.User;
import com.mira.repository.UserRepository;
import com.mira.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(String id) {
        return userRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.findById(user.getId())
                .map(newUser -> {
                    newUser.setMail(user.getMail());
                    newUser.setSurname(user.getSurname());
                    newUser.setName(user.getName());
                    return userRepository.save(newUser);
                })
                .orElse(user);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID uuid) {
        userRepository.deleteById(uuid);
    }
}
