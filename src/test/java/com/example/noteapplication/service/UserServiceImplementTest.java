package com.example.noteapplication.service;

import com.example.noteapplication.Data.Models.User;
import com.example.noteapplication.Data.Repository.UserRepository;
import com.example.noteapplication.Data.dto.request.UserLoginRequest;
import com.example.noteapplication.Data.dto.request.UserRegistrationRequest;
import com.example.noteapplication.Data.dto.request.UserUpdateRequest;
import com.example.noteapplication.Data.dto.response.UserDeleteResponse;
import com.example.noteapplication.Data.dto.response.UserRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplementTest {
    @Autowired
    UserService userService;
    UserRegistrationRequest registrationRequest;
    UserRegistrationRequest registrationRequest2;
    UserLoginRequest userLoginRequest;
    UserUpdateRequest updateRequest;

    UserDeleteResponse userDeleteResponse;
    @BeforeEach
    void setUp() {
        registrationRequest = new UserRegistrationRequest();
        registrationRequest.setFirstName("perry");
        registrationRequest.setLastName("derek");
        registrationRequest.setEmailAddress("perryDerek@gmail.com");
        registrationRequest.setPassword("perry@25");
        registrationRequest.setPhoneNumber("07069052656");

        registrationRequest2 = new UserRegistrationRequest();
        registrationRequest2.setFirstName("vicent");
        registrationRequest2.setLastName("Elisha");
        registrationRequest2.setEmailAddress("vincentElisha@gmail.com");
        registrationRequest2.setPassword("vincent@50");
        registrationRequest2.setPhoneNumber("07023424567");

        userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmailAddress("perryDerek@gmail.com");
        userLoginRequest.setPassword("perry@25");


    }
    @Test
    void registerTest() {
        UserRegistrationResponse registrationResponse = userService.register(registrationRequest);
        userService.register(registrationRequest2);
        assertEquals(201, registrationResponse.getStatusCode());
    }

    @Test
    void loginTest() {
//        userService.register(registrationRequest);


        var userResponse = userService.login(userLoginRequest);
        assertEquals("Login Successful", userResponse.getMessage());

    }

    @Test
    void updateTest() {
        userService.register(registrationRequest);
        userService.register(registrationRequest2);
        updateRequest = new UserUpdateRequest();
        updateRequest.setId(7);
        updateRequest.setFirstName("Emmanuel");
        updateRequest.setLastName("Derek");
        updateRequest.setEmailAddress("obusehemmanuel@gmail.com");
        updateRequest.setPassword("emma@24");
        updateRequest.setPhoneNumber("07056661496");
        var userResponse = userService.update(updateRequest);
        assertEquals(201, userResponse.getStatusCode());

    }

    @Test
    void delete() {
    var response =    userService.delete(2);

        assertEquals(201,response.getStatusCode());
    }

    @Test
    void deleteAll(){
    var response =    userService.deleteAll();
    assertEquals(201,response.getStatusCode());
    }
}
