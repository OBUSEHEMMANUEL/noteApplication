package com.example.noteapplication.Data.Repository;

import com.example.noteapplication.Data.Models.Entries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  EntriesRepository extends JpaRepository<Entries,Integer> {

    Optional<Entries> findByTitle(String title);

//    Optional<Entries> deleteEntryByTitle(String title);
}
