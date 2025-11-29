package com.example.LibraryManagement.Entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class IssueEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long issueId;
private long studentId;
private long bookId;
private LocalDate issueDate;
private LocalDate returnDate;
public long getId() {
    return issueId;
}
public void setId(long id) {
    this.issueId = id;
}
public long getStudentId() {
    return studentId;
}
public void setStudentId(long studentId) {
    this.studentId = studentId;
}
public long getBookId() {
    return bookId;
}
public void setBookId(long bookId) {
    this.bookId = bookId;
}
public LocalDate getIssueDate() {
    return issueDate;
}
public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
}
public LocalDate getReturnDate() {
    return returnDate;
}
public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
}

}
