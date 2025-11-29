package com.example.LibraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagement.Entities.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity,Long> {
    StudentEntity findByContactNo(String contactNo);
}
