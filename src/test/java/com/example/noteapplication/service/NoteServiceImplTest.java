package com.example.noteapplication.service;

import com.example.noteapplication.Data.Models.Note;
import com.example.noteapplication.Data.dto.request.NoteCreateRequest;
import com.example.noteapplication.Data.dto.request.NoteRetrieveRequest;
import com.example.noteapplication.Data.dto.request.NoteUpdateRequest;
import com.example.noteapplication.Data.dto.request.RetrieveRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NoteServiceImplTest {

    @Autowired
    NoteService noteService;
    NoteCreateRequest noteCreateRequest;
    NoteUpdateRequest noteUpdateRequest;


    @BeforeEach
    void setUp() {
        noteCreateRequest= new NoteCreateRequest();



    }

    @Test
    void createNote() {
        noteCreateRequest.setName("Django");
        noteService.createNote(noteCreateRequest);
        assertEquals(5,noteService.viewAll().size());
    }

    @Test
    void retrieveNote() {
        NoteRetrieveRequest request = new NoteRetrieveRequest();
        request.setName("Django");

        assertEquals(201, noteService.retrieveNote(request).getStatusCode());
    }

    @Test
    void updateNote() {
        noteUpdateRequest = new NoteUpdateRequest();
        noteUpdateRequest.setId(3);
        noteUpdateRequest.setName("inheritance");
        noteService.updateNote(noteUpdateRequest);
        assertEquals(3,noteService.viewAll().size());

    }
    @Test
    void findAllTest(){
        System.out.println(noteService.viewAll());
    }

    @Test
    void deleteNote() {


        noteService.deleteNote(3);
        assertEquals(2,noteService.viewAll().size());

    }

    @Test
    void deleteAll() {
        noteService.deleteAll();
        assertEquals(0,noteService.viewAll().size());
    }
}