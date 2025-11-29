package com.example.LibraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagement.Entities.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity,Long> {
    BookEntity findByBookName(String name);

}
