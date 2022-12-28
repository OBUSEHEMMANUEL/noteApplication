package com.example.noteapplication.Data.Models;

import lombok.Data;


import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Data
public class Entries{
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String body;
    private LocalDateTime localDateTime;

  @ManyToOne
  private Note note;


}