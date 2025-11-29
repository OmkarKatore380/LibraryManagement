package com.example.LibraryManagement.Service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LibraryManagement.Entities.AddBookDto;
import com.example.LibraryManagement.Entities.BookDto;
import com.example.LibraryManagement.Entities.BookEntity;
import com.example.LibraryManagement.Entities.IssueEntity;
import com.example.LibraryManagement.Entities.StudentDto;
import com.example.LibraryManagement.Entities.StudentEntity;
import com.example.LibraryManagement.Repository.BookRepo;
import com.example.LibraryManagement.Repository.IssueRepo;
import com.example.LibraryManagement.Repository.StudentRepo;

@Service
public class ServiceImplement implements LibraryService {
@Autowired
private BookRepo repo;
@Autowired
private ModelMapper modelMapper;
@Autowired
private StudentRepo sRepo;
@Autowired
private IssueRepo issueRepo;

//Book
@Override
public BookDto addNewBook(AddBookDto addbookDto) {
    BookEntity book=modelMapper.map(addbookDto,BookEntity.class);
    BookEntity saveBook=repo.save(book);
    return modelMapper.map(saveBook,BookDto.class);
}
@Override
public BookDto getBookByName(String name) {
   BookEntity book=repo.findByBookName(name);
   return modelMapper.map(book,BookDto.class);
}
@Override
public List<BookDto> getAllBooks() {
    List<BookEntity> books=repo.findAll();
    return modelMapper.map(books,new org.modelmapper.TypeToken<List<BookDto>>(){}.getType());
}

@Override
public BookDto updateBook(Long bookId, AddBookDto addBookDto) {

   BookEntity book = repo.findById(bookId).orElseThrow(()->new RuntimeException("Book not found"));
    book.setBookName(addBookDto.getBookName());
   book.setAuthor(addBookDto.getBookName());
   book.setAvailable(addBookDto.isAvailable());
    return modelMapper.map(repo.save(book),BookDto.class);
}
@Override
public BookDto deleteBook(Long bookId) {
    BookEntity book=repo.findById(bookId).orElseThrow(()->new RuntimeException("Book not found"));
    repo.deleteById(bookId);
    return modelMapper.map(book,BookDto.class);
}

//Student
@Override
public StudentDto addNewStudent(StudentDto studentDto) {
    StudentEntity student=modelMapper.map(studentDto,StudentEntity.class);
    StudentEntity saveStudent=sRepo.save(student);
    return modelMapper.map(saveStudent,StudentDto.class);
}
@Override
public StudentDto getStdByContact(String contactNo) {
    StudentEntity student=sRepo.findByContactNo(contactNo);
    return modelMapper.map(student,StudentDto.class);
}
@Override
public List<StudentDto> getAllStudent() {
   List<StudentEntity> students=sRepo.findAll();
   return modelMapper.map(students,new org.modelmapper.TypeToken<List<StudentDto>>(){}.getType());
}
@Override
public StudentDto updateStudent(Long studentId, StudentDto studentDto) {
    StudentEntity student=sRepo.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));
    student.setName(studentDto.getName());
    student.setContactNo(studentDto.getContactNo());
    return modelMapper.map(sRepo.save(student),StudentDto.class);
}
@Override
public StudentDto deleteStudent(Long studentId) {
     StudentEntity student=sRepo.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));
     sRepo.deleteById(studentId);
     return modelMapper.map(student, StudentDto.class);
}
@Override
public IssueEntity issueBook(Long studentId, Long bookId) {
    BookEntity book=repo.findById(bookId).orElseThrow(()->new RuntimeException("Book not found"));
    if(!book.isAvailable()){
        throw new RuntimeException("Book already issue");
    }
    IssueEntity issue=new IssueEntity();
    issue.setBookId(bookId);
    issue.setStudentId(studentId);
    issue.setIssueDate(LocalDate.now());
    issue.setReturnDate(null);
    book.setAvailable(false);
    repo.save(book);
    return issueRepo.save(issue);
}
@Override
public IssueEntity returnBook(Long bookId) {
    IssueEntity issue = issueRepo.findByBookIdAndReturnDateIsNull(bookId)
            .orElseThrow(() -> new RuntimeException("Book not currently issued!"));

    issue.setReturnDate(LocalDate.now());
    issueRepo.save(issue);

    // Set book available = true
    BookEntity book = repo.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book Not Found"));

    book.setAvailable(true);
    repo.save(book);

    return issue;

}
@Override
public List<IssueEntity> getIssueHistory() {
    return issueRepo.findAll();
}
}
