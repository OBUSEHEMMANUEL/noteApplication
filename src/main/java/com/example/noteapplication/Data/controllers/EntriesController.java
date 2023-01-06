package com.example.noteapplication.Data.controllers;

import com.example.noteapplication.Data.dto.request.EntriesUpdateRequest;
import com.example.noteapplication.Data.dto.request.EntryCreateRequest;
import com.example.noteapplication.Data.dto.request.RetrieveRequest;
import com.example.noteapplication.Data.dto.response.EntryResponse;
import com.example.noteapplication.service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntriesController {
    @Autowired
    EntriesService entriesService;
    @PostMapping("api/noteApplication/entries")
    public ResponseEntity<?> create(@RequestBody EntryCreateRequest request){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(entriesService.createEntry(request));
        }catch (RuntimeException exception){
            EntryResponse response = new EntryResponse();
            response.setMessage(exception.getMessage());
            response.setStatusCode(401);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entriesService.createEntry(request));
        }
    }
    @GetMapping("api/noteApplication/entries/retrieve")
    public ResponseEntity<?> retrieveEntry(@PathVariable RetrieveRequest request){
        return ResponseEntity.ok(entriesService.retrieveEntry(request));
    }
    @PatchMapping("api/noteApplication/entries/update")
    public ResponseEntity<?> updateEntry(@RequestBody EntriesUpdateRequest request){
        return ResponseEntity.ok(entriesService.updateEntry(request));
    }
    @DeleteMapping("api/noteApplication/entries/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return ResponseEntity.ok(entriesService.deleteEntry(id));
    }
}
