package com.example.noteapplication.Data.dto.request;

import com.example.noteapplication.Data.Models.Entries;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Data
public class NoteUpdateRequest {
    private int id;
    private String name;
    Set<Entries> entries;
}
