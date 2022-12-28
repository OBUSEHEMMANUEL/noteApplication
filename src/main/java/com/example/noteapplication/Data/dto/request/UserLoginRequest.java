package com.example.noteapplication.Data.dto.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String emailAddress;
    private String password;
}
