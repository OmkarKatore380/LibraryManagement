package com.example.LibraryManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagement.Entities.IssueEntity;

public interface IssueRepo extends JpaRepository<IssueEntity,Long>{
Optional<IssueEntity> findByBookIdAndReturnDateIsNull(Long bookId);

}
