package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDTO {

    private String username;
    private String email;
    private String phone;
    private List<String> roles;

}
