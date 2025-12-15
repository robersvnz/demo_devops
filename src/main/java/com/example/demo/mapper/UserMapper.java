package com.example.demo.mapper;

import com.example.demo.dto.response.UserResponseDTO;
import com.example.demo.model.Role;
import com.example.demo.model.User;

public class UserMapper {

    public static UserResponseDTO toDto(User user) {
        return UserResponseDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .roles(
                        user.getRoles().stream()
                                .map(Role::getRoleName)
                                .toList()
                )
                .build();
    }

}
