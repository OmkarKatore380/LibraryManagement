package com.example.LibraryManagement.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.Entities.AddBookDto;
import com.example.LibraryManagement.Entities.BookDto;
import com.example.LibraryManagement.Entities.IssueEntity;
import com.example.LibraryManagement.Entities.StudentDto;
import com.example.LibraryManagement.Service.LibraryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class LibraryController {
@Autowired
private LibraryService service;
//////////////////////////////////////////////////////////////////////////
//Book
@PostMapping("/book")
public BookDto postMethodName(@RequestBody AddBookDto addbookDto) {
    return service.addNewBook(addbookDto);
}
@GetMapping("/book/Author/{name}")
public BookDto getMethodName(@PathVariable String name) {
    return service.getBookByName(name);
}
@GetMapping("/book")
public List<BookDto> allBooks() {
    return service.getAllBooks();
}

@PutMapping("/book/{bookId}")
public BookDto putMethodName(@PathVariable Long bookId, @RequestBody AddBookDto addBookDto) {
    return service.updateBook(bookId,addBookDto);
}
@DeleteMapping("/book/{bookId}")
public BookDto delete(@PathVariable Long bookId){
    return service.deleteBook(bookId);
}
////////////////////////////////////////////////////////////////////
//Student
@PostMapping("/student")
public StudentDto postMethodName(@RequestBody StudentDto studentDto) {
    return service.addNewStudent(studentDto);
}
@GetMapping("/student/contact_no/{contactNo}")
public StudentDto contact(@PathVariable String contactNo) {
    return service.getStdByContact(contactNo);
}
@GetMapping("/student")
public List<StudentDto> allStudent() {
    return service.getAllStudent();
}
@PutMapping("/student/{studentId}")
public StudentDto putMethodName(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {    
    return service.updateStudent(studentId,studentDto);
}
@DeleteMapping("/student/delete/{id}")
public StudentDto deleteStd(@PathVariable Long studentId){
    return service.deleteStudent(studentId);
}
///////////////////////////////////////////////////
//Issue
@PostMapping("/issue/{studentId}/{bookId}")
public IssueEntity postMethodName(@PathVariable Long studentId, @PathVariable Long bookId) {    
    return service.issueBook(studentId,bookId);
}
@PutMapping("/return/{bookId}")
public IssueEntity postMethodName(@PathVariable Long bookId) {
    return service.returnBook(bookId);
}
@GetMapping("/issue/history")
public List<IssueEntity> history() {
    return service.getIssueHistory();
}
}
