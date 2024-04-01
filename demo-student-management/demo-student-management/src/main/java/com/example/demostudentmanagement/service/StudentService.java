package com.example.demostudentmanagement.service;

import com.example.demostudentmanagement.dto.StudentDto;
import com.example.demostudentmanagement.dto.request.StudentUpdateDTo;
import com.example.demostudentmanagement.entity.Student;

import java.util.List;

public interface StudentService {


  

    public String saveStudent(StudentDto studentDto);


    String updateStudent(StudentUpdateDTo studentUpdateDTo);

    StudentDto getStudentById(int sid);

    List<StudentDto> getAllStudents();

    String deleteStudent(int sid);



}
