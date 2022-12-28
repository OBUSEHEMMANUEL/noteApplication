package com.example.noteapplication.Data.Models;

import lombok.Data;


import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class Note{
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Entries> entries = new HashSet<>();
}


