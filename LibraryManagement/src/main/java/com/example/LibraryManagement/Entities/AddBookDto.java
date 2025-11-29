package com.example.LibraryManagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookDto {
private String bookName;
private String author;
private boolean available;
}
