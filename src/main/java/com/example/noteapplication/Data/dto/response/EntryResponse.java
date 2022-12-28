package com.example.noteapplication.Data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryResponse {
    private String message;
    private int statusCode;
}
