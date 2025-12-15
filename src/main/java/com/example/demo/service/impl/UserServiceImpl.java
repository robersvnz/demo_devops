package com.example.demo.service.impl;

import com.example.demo.dto.response.ListResponseDTO;
import com.example.demo.dto.response.UserCreated;
import com.example.demo.dto.response.UserResponseDTO;
import com.example.demo.excepcion.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.MessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ListResponseDTO<UserResponseDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();

        List<UserResponseDTO> userDTO = userList.stream()
                .map(UserMapper::toDto)
                .toList();

        return ListResponseDTO.<UserResponseDTO>builder()
                .success(true)
                .message(MessageConstants.USER_LIST_FETCHED_SUCCESS)
                .data(userDTO)
                .total(userDTO.size())
                .build();
    };

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(MessageConstants.USER_NOT_FOUND + userId));
    }

    @Override
    public UserCreated createUser(User user) {

        try {

            UserCreated response = UserCreated.builder()
                    .message(MessageConstants.USER_CREATED_SUCCESS)
                    .username(user.getUsername())
                    .status(HttpStatus.valueOf(HttpStatus.CREATED.value()))
                    .build();

            userRepository.save(user);

            return response;

        } catch (Exception e) {
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }



    }

    @Override
    public User updateUser(Long userId, User user) {
        User userToUpdate = getUserById(userId);

        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setPassword(user.getPassword());
        userRepository.save(userToUpdate);

        return userToUpdate;
    }

    @Override
    public void deleteUser(Long userId) {
        User userToDelete = getUserById(userId);
        userRepository.delete(userToDelete);
    }
}
