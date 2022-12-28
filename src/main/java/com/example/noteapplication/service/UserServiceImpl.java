package com.example.noteapplication.service;

import com.example.noteapplication.Data.Exceptions.UserException;
import com.example.noteapplication.Data.Models.User;
import com.example.noteapplication.Data.Repository.UserRepository;
import com.example.noteapplication.Data.dto.request.UserLoginRequest;
import com.example.noteapplication.Data.dto.request.UserRegistrationRequest;
import com.example.noteapplication.Data.dto.request.UserUpdateRequest;
import com.example.noteapplication.Data.dto.response.UserDeleteResponse;
import com.example.noteapplication.Data.dto.response.UserLoginResponse;
import com.example.noteapplication.Data.dto.response.UserRegistrationResponse;
import com.example.noteapplication.Data.dto.response.UserUpdateResponse;
import com.example.noteapplication.Validator.UserDetailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserRegistrationResponse register(UserRegistrationRequest request) {
        if (!UserDetailValidator.isValidEmailAddress(request.getEmailAddress()))
            throw new UserException("Email does not match");
        if(!UserDetailValidator.isValidPassword(request.getPassword()))
            throw new UserException("Password does not match");
        if (!UserDetailValidator.isValidPhoneNumber(request.getPhoneNumber()))
            throw new UserException("PhoneNumber Invalid");
        var user= buildRequest(request);

           var savedUser =         userRepository.save(user);

        return buildResponse(savedUser);

    }

    private UserRegistrationResponse buildResponse(User savedUser) {
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setMessage("UserRegistration Successful");
        response.setStatusCode(201);
        response.setId(savedUser.getId());

        return response;
    }

    private User buildRequest(UserRegistrationRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setEmailAddress(request.getEmailAddress());
        return user;
    }

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
    var foundUser =  userRepository.findByEmailAddress(request.getEmailAddress())
            .orElseThrow(()->new RuntimeException("Wrong EmailAddress"));
      UserLoginResponse loginResponse = new UserLoginResponse();
      if (foundUser.getPassword().equals(request.getPassword())){
          if (foundUser.getEmailAddress().equals(request.getEmailAddress())){
              loginResponse.setMessage("Login Successful");
              return loginResponse;
          }
      }
      loginResponse.setMessage("AUTHENTICATION FAILED");
      return loginResponse;
    }

    @Override
    public UserUpdateResponse update(UserUpdateRequest updateRequest) {
      var foundUser =  userRepository.findById(updateRequest.getId())
              .orElseThrow(()->new RuntimeException("Wrong id"));

      foundUser.setFirstName(updateRequest.getFirstName());
      foundUser.setLastName(updateRequest.getLastName());
      foundUser.setEmailAddress(updateRequest.getEmailAddress() != null && !updateRequest.getEmailAddress().equals("")
              ? updateRequest.getEmailAddress(): foundUser.getEmailAddress());
      foundUser.setPhoneNumber(updateRequest.getPassword() != null && !updateRequest.getPassword().equals("")
              ? updateRequest.getPhoneNumber(): foundUser.getPhoneNumber());
      foundUser.setPassword(updateRequest.getPassword() != null && !updateRequest.getPassword().equals("")
                ? updateRequest.getPassword() : foundUser.getPassword());

            var savedUser =        userRepository.save(foundUser);

      UserUpdateResponse response = new UserUpdateResponse();
            response.setMessage("Update Successful");
            response.setStatusCode(201);
            return response;
    }

    @Override
    public UserDeleteResponse delete(int id) {
         userRepository.deleteById(id);
          return new UserDeleteResponse("DELETE SUCCESSFUL", 201);
    }

    @Override
    public UserDeleteResponse deleteAll() {
        userRepository.deleteAll();
        return new UserDeleteResponse("DELETE SUCESSFUL",201);
    }
}
