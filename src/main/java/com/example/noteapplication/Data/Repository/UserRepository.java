package com.example.noteapplication.Data.Repository;

import com.example.noteapplication.Data.Models.User;
import com.example.noteapplication.Data.dto.request.UserLoginRequest;
import jakarta.persistence.OneToMany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {



    Optional<User> findByEmailAddress(String emailAddress);
}
