package com.example.demo.service;

import com.example.demo.dto.response.ListResponseDTO;
import com.example.demo.dto.response.UserCreated;
import com.example.demo.dto.response.UserResponseDTO;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    ListResponseDTO<UserResponseDTO> getAllUsers();

    User getUserById(Long userId);

    UserCreated createUser(User user);

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);

}
