package com.example.LibraryManagement.Service;

import java.util.List;

import com.example.LibraryManagement.Entities.AddBookDto;
import com.example.LibraryManagement.Entities.BookDto;
import com.example.LibraryManagement.Entities.IssueEntity;
import com.example.LibraryManagement.Entities.StudentDto;

public interface LibraryService {
public BookDto addNewBook(AddBookDto addbookDto);
public BookDto getBookByName(String name);
public List<BookDto> getAllBooks();
public BookDto updateBook(Long bookId, AddBookDto addBookDto);
public BookDto deleteBook(Long bookId);
public StudentDto addNewStudent(StudentDto studentDto);
public StudentDto getStdByContact(String contactNo);
public List<StudentDto> getAllStudent();
public StudentDto updateStudent(Long studentId,StudentDto studentDto);
public StudentDto deleteStudent(Long studentId);
public IssueEntity issueBook(Long studentId,Long bookId);
public IssueEntity returnBook(Long bookId);
public List<IssueEntity> getIssueHistory();
}
