package com.example.noteapplication.Data.controllers;

import com.example.noteapplication.Data.Exceptions.UserException;
import com.example.noteapplication.Data.Models.User;
import com.example.noteapplication.Data.dto.request.UserLoginRequest;
import com.example.noteapplication.Data.dto.request.UserRegistrationRequest;
import com.example.noteapplication.Data.dto.request.UserUpdateRequest;
import com.example.noteapplication.Data.dto.response.UserRegistrationResponse;
import com.example.noteapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
   @PostMapping("api/noteApplication/user")
    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest request){
    try{
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(request));
    }catch (UserException e){
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setMessage(e.getMessage());
        response.setStatusCode(401);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userService.register(request));
    }
}

    @PostMapping("api/noteApplication/user/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request){
       return ResponseEntity.ok(userService.login(request));
}
    @PatchMapping("api/noteApplication/user/update")
    public ResponseEntity<?> update(@RequestBody UserUpdateRequest request){
       return ResponseEntity.ok(userService.update(request));
    }
    @DeleteMapping("api/noteApplication/user/delete/{id}")
   public ResponseEntity<?> delete(@PathVariable int id){
       return ResponseEntity.ok(userService.delete(id));
   }
}
