package com.example.noteapplication.Data.dto.response;

import lombok.Data;

@Data
public class UserUpdateResponse {
    private int id;
    private int statusCode;
    private String message;
}
