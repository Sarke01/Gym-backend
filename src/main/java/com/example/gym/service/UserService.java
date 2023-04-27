package com.example.gym.service;

import com.example.gym.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UserService {
    User getUserById(int id) throws ChangeSetPersister.NotFoundException;

    List<User> getAllUsers();

    User createUser(User user);
    User getUserByUsername(String username);
}

