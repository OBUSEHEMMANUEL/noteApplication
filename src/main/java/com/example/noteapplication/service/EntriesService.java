package com.example.noteapplication.service;

import com.example.noteapplication.Data.dto.request.EntryCreateRequest;
import com.example.noteapplication.Data.dto.request.RetrieveRequest;
import com.example.noteapplication.Data.dto.request.EntriesUpdateRequest;
import com.example.noteapplication.Data.dto.response.EntryResponse;

public interface EntriesService {
    EntryResponse createEntry(EntryCreateRequest request);
    EntryResponse retrieveEntry(RetrieveRequest request);
    EntryResponse updateEntry(EntriesUpdateRequest request);
    EntryResponse deleteEntry(int id);
    EntryResponse deleteAllEntry();
}
