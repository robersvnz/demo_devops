package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class UserCreated {

    private String message;
    private String username;
    private HttpStatus status;

}
