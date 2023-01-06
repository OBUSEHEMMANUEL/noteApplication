package com.example.noteapplication.service;

import com.example.noteapplication.Data.Models.Entries;
import com.example.noteapplication.Data.Models.Note;
import com.example.noteapplication.Data.Repository.EntriesRepository;
import com.example.noteapplication.Data.dto.request.EntriesUpdateRequest;
import com.example.noteapplication.Data.dto.request.EntryCreateRequest;
import com.example.noteapplication.Data.dto.request.RetrieveRequest;
import com.example.noteapplication.Data.dto.response.EntryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EntriesServiceImpl implements EntriesService{
    @Autowired
    EntriesRepository entriesRepository;
    @Autowired
    NoteService noteService;
    @Override
    public EntryResponse createEntry(EntryCreateRequest request) {
        Entries entries = new Entries();

        entries.setBody(request.getBody());
        entries.setTitle(request.getTitle());
        entries.setLocalDateTime(request.getLocalDateTime());
        entries.setNoteId(request.getPostId());
        var savedEntry = entriesRepository.save(entries);
        noteService.addEntries(request.getPostId(),savedEntry);
        EntryResponse entryResponse = new EntryResponse();

        entryResponse.setMessage("Entry Stored");
        entryResponse.setStatusCode(201);
        return  entryResponse;

    }

    @Override
    public EntryResponse retrieveEntry(RetrieveRequest request) {
     var entry =   entriesRepository.findByTitle(request.getTitle()).orElseThrow(()-> new RuntimeException("Title not found"));
     EntryResponse response = new EntryResponse();
     response.setMessage("Title Found");
     response.setStatusCode(201);
     return response;
    }

    @Override
    public EntryResponse updateEntry(EntriesUpdateRequest request) {
        var foundEntry =   entriesRepository.findById(request.getId()).orElseThrow(()-> new RuntimeException("ID NOT FOUND"));
        foundEntry.setTitle(request.getTitle());
        foundEntry.setBody(request.getBody());
        var savedEntry = entriesRepository.save(foundEntry);
        EntryResponse entryResponse = new EntryResponse();

        entryResponse.setMessage("Entry Stored");
        entryResponse.setStatusCode(201);
        return  entryResponse;

    }

    @Override
    public EntryResponse deleteEntry(int id) {
        entriesRepository.deleteById(id);
        return new EntryResponse("DELETED SUCCESSFULLY",201);
    }

    @Override
    public EntryResponse deleteAllEntry() {
        entriesRepository.deleteAll();
        return new EntryResponse("DELETED SUCCESSFULLY",201);
    }
}
