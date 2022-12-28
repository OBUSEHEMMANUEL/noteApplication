package com.example.noteapplication.service;

import com.example.noteapplication.Data.dto.request.UserLoginRequest;
import com.example.noteapplication.Data.dto.request.UserUpdateRequest;
import com.example.noteapplication.Data.dto.response.UserDeleteResponse;
import com.example.noteapplication.Data.dto.response.UserUpdateResponse;
import com.example.noteapplication.Data.dto.response.UserLoginResponse;
import com.example.noteapplication.Data.dto.request.UserRegistrationRequest;
import com.example.noteapplication.Data.dto.response.UserRegistrationResponse;

public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest request);
    UserLoginResponse login(UserLoginRequest request);
    UserUpdateResponse update(UserUpdateRequest request);
    UserDeleteResponse delete(int id);

    UserDeleteResponse deleteAll();

}
