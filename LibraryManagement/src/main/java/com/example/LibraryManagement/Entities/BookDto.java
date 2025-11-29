package com.example.LibraryManagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private long bookId;
private String bookName;
private String author;
private boolean available;
}
