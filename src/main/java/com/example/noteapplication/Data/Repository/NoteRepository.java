package com.example.noteapplication.Data.Repository;

import com.example.noteapplication.Data.Models.Note;
import com.example.noteapplication.Data.dto.request.NoteRetrieveRequest;
import com.example.noteapplication.Data.dto.response.NoteResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Integer> {
    Note findByName(String request);
}

