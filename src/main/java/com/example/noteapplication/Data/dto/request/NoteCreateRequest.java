package com.example.noteapplication.Data.dto.request;

import com.example.noteapplication.Data.Models.Entries;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
public class NoteCreateRequest {
    private String name;
    private Entries entries;
}
