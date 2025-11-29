package com.example.LibraryManagement.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
private long studentId;
private String name;
private String contactNo;
public long getId() {
    return studentId;
}
public void setId(long id) {
    this.studentId = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getContactNo() {
    return contactNo;
}
public void setContactNo(String contactNo) {
    this.contactNo = contactNo;
}

}
