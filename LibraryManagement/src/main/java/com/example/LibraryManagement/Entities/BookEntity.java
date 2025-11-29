package com.example.LibraryManagement.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
private long bookId;
private String bookName;
private String author;
private boolean available;
public long getId() {
    return bookId;
}
public void setId(long id) {
    this.bookId = id;
}
public String getBookName() {
    return bookName;
}
public void setBookName(String bookName) {
    this.bookName = bookName;
}
public String getAuthor() {
    return author;
}
public void setAuthor(String author) {
    this.author = author;
}
public boolean isAvailable() {
    return available;
}
public void setAvailable(boolean available) {
    this.available = available;
}

}
