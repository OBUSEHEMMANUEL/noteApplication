package com.example.noteapplication.Data.controllers;

import com.example.noteapplication.Data.Models.Entries;
import com.example.noteapplication.Data.dto.request.NoteCreateRequest;
import com.example.noteapplication.Data.dto.request.NoteRetrieveRequest;
import com.example.noteapplication.Data.dto.request.NoteUpdateRequest;
import com.example.noteapplication.Data.dto.response.NoteResponse;
import com.example.noteapplication.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {
    @Autowired
    NoteService noteService;
    @PostMapping("api/noteApplication/note")
    public ResponseEntity<?> createNote(@RequestBody NoteCreateRequest request){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(request));
        }catch (RuntimeException exception){
            NoteResponse response = new NoteResponse();
            response.setMessage(exception.getMessage());
            response.setStatusCode(401);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(noteService.createNote(request));
        }
    }
    @GetMapping("api/noteApplication/note/retrieve")
    public ResponseEntity<?> retrieveNote(@RequestBody NoteRetrieveRequest request){
        return ResponseEntity.ok(noteService.retrieveNote(request));
    }
//    @PostMapping("api/noteApplication/note/addEntries")
//    public ResponseEntity<?> addEntries(@RequestBody int id, Entries entry){
//        return ResponseEntity.ok(noteService.addEntries(id,entry));
//    }
    @PatchMapping("api/noteApplication/note/update")
    public ResponseEntity<?> updateNote(@RequestBody NoteUpdateRequest request){
        return  ResponseEntity.ok(noteService.updateNote(request));
    }
    @DeleteMapping("api/noteApplication/note/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable int id){
        return ResponseEntity.ok(noteService.deleteNote(id));
    }

}
