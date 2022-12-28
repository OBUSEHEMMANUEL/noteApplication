package com.example.noteapplication.Data.Models;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    @OneToOne
    private Note note;
}
