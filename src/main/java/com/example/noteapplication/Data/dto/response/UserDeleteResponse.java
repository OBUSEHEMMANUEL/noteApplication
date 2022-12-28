package com.example.noteapplication.Data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class UserDeleteResponse {
    private String message;
    private int statusCode;


}
