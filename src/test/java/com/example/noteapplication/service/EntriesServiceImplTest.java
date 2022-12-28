package com.example.noteapplication.service;

import com.example.noteapplication.Data.Repository.EntriesRepository;
import com.example.noteapplication.Data.dto.request.EntriesUpdateRequest;
import com.example.noteapplication.Data.dto.request.EntryCreateRequest;
import com.example.noteapplication.Data.dto.request.RetrieveRequest;
import com.example.noteapplication.Data.dto.response.EntryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EntriesServiceImplTest {
    @Autowired
    EntriesService entriesService;
    EntryCreateRequest createRequest;
    EntryCreateRequest createRequest2;

    @BeforeEach
    void setUp() {
        createRequest = new EntryCreateRequest();
        createRequest.setPostId(3);
        createRequest.setTitle("LEKAN THE DADA BOY");
        createRequest.setBody("Lekan is a dada boy and he is black");
        createRequest.setLocalDateTime(LocalDateTime.now());



    }

    @Test
    void createEntry() {
        createRequest2 = new EntryCreateRequest();
        createRequest2.setPostId(1);
        createRequest2.setTitle("OLIVER TWIST WANTS MORE");
        createRequest2.setBody("Lekan and oliver twist are best friends");
        createRequest2.setLocalDateTime(LocalDateTime.now());

//     var entry =   entriesService.createEntry(createRequest);
 var entry =    entriesService.createEntry(createRequest2);
     assertEquals(201,entry.getStatusCode());
    }

    @Test
    void retrieveEntry() {
        RetrieveRequest request = new RetrieveRequest();
        request.setTitle("OLIVER TWIST WANTS MORE");
      var entry =  entriesService.retrieveEntry(request);
      assertEquals(201,entry.getStatusCode());
    }

    @Test
    void updateEntry() {
        EntriesUpdateRequest request = new EntriesUpdateRequest();
        request.setId(1);
        request.setTitle("THE DADA BOY CALLED LEKAN");
        request.setBody("The dada, black boy is called lekan");
        var entry = entriesService.updateEntry(request);
        assertEquals(201,entry.getStatusCode());
    }
    @Test
    void deleteEntry() {
    var entry =    entriesService.deleteEntry(4);
          entriesService.deleteEntry(5);

        assertEquals(201,entry.getStatusCode());
    }

    @Test
    void deleteAllEntry() {
        var entry = entriesService.deleteAllEntry();
        assertEquals(201,entry.getStatusCode());
    }
}