package com.example.noteapplication.service;

import com.example.noteapplication.Data.Models.Entries;
import com.example.noteapplication.Data.Models.Note;
import com.example.noteapplication.Data.Repository.NoteRepository;
import com.example.noteapplication.Data.dto.request.NoteCreateRequest;
import com.example.noteapplication.Data.dto.request.NoteRetrieveRequest;
import com.example.noteapplication.Data.dto.request.NoteUpdateRequest;
import com.example.noteapplication.Data.dto.response.EntryResponse;
import com.example.noteapplication.Data.dto.response.NoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    NoteRepository noteRepository;

    @Override
    public NoteResponse createNote(NoteCreateRequest request) {
        Note note = new Note();
        note.setName(request.getName());
        noteRepository.save(note);
        NoteResponse response = new NoteResponse();
        response.setMessage("Note Created Successfully");
        response.setStatusCode(201);
        return response;
    }
    public NoteResponse addEntries(int id, Entries entry) {
        var savedNote = noteRepository.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
        savedNote.getEntries().add(entry);
        noteRepository.save(savedNote);
        NoteResponse response = new NoteResponse();
        response.setMessage("Entries Saved successfully");
        response.setStatusCode(201);
        return response;
    }


    @Override
    public NoteResponse retrieveNote(NoteRetrieveRequest request) {
      var foundName =  noteRepository.findByName(request.getName());
        NoteResponse response = new NoteResponse();
        response.setMessage("Title Found");
        response.setStatusCode(201);
        return response;
    }

    @Override
    public NoteResponse updateNote(NoteUpdateRequest request) {
     var foundNote =   noteRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("ID ISN'T FOUND"));
     foundNote.setName(request.getName());
     noteRepository.save(foundNote);

        NoteResponse response = new NoteResponse();
        response.setMessage("Update successful");
        response.setStatusCode(201);
        return response;
    }
    @Override
    public NoteResponse deleteNote(int id) {
        noteRepository.deleteById(id);

        NoteResponse response = new NoteResponse();
        response.setMessage("Deleted successful");
        response.setStatusCode(201);
        return response;
    }

    @Override
    public List<Note> viewAll() {
        return noteRepository.findAll();
    }

    @Override
    public void deleteAll() {

    }
}
