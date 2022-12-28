package com.example.noteapplication.Data.dto.response;

import lombok.Data;

@Data
public class UserLoginResponse {
    private int id;
    private int statusCode;
    private String message;
}
