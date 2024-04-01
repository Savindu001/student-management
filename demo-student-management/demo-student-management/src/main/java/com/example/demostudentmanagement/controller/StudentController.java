package com.example.demostudentmanagement.controller;


import com.example.demostudentmanagement.dto.StudentDto;
import com.example.demostudentmanagement.dto.request.StudentUpdateDTo;
import com.example.demostudentmanagement.entity.Student;
import com.example.demostudentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
  public String saveStudent(@RequestBody StudentDto studentDto){
        studentService.saveStudent(studentDto);
         return "saved";
  }

  @PutMapping("/update")
    public String updateStudent(@RequestBody StudentUpdateDTo studentUpdateDTo)
  {
      studentService.updateStudent(studentUpdateDTo);
      return "updated";
  }
//
//  @GetMapping(
//          path="get-by-id",
//          params="id"
//  )
//
//    public StudentDto getStudentById(@RequestParam(value="id")int sid){
//        StudentDto studentDto=studentService.getStudentById(sid);
//        return  studentDto;
//
//  }

  @GetMapping(
          path="/get-all-students"
  )

    public List<StudentDto> getAllStudents()
  {
      List<StudentDto>allstudents=studentService.getAllStudents();
      return allstudents;
  }


  @DeleteMapping(

          path="/delete-student/{id}"
  )

    public String deleteStudent(@PathVariable(value = "id") int sid){
        String deleted=studentService.deleteStudent(sid);
        return deleted;
  }




}
