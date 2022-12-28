package com.example.noteapplication.Data.dto.request;

import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
}
