package com.example.noteapplication.service;

import com.example.noteapplication.Data.Models.Entries;
import com.example.noteapplication.Data.Models.Note;
import com.example.noteapplication.Data.dto.request.NoteCreateRequest;
import com.example.noteapplication.Data.dto.request.NoteRetrieveRequest;
import com.example.noteapplication.Data.dto.request.NoteUpdateRequest;
import com.example.noteapplication.Data.dto.response.NoteResponse;

import java.util.List;

public interface NoteService {
    NoteResponse createNote(NoteCreateRequest request);
    NoteResponse retrieveNote(NoteRetrieveRequest request);
    public NoteResponse addEntries(int id, Entries entry);
    NoteResponse updateNote(NoteUpdateRequest request);
    NoteResponse deleteNote(int id);

    List<Note> viewAll();
    void deleteAll();
}
