package com.example.noteapplication.Data.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EntriesUpdateRequest {
    private int id;
    private String title;
    private String body;
    private LocalDateTime localDateTime;
}
