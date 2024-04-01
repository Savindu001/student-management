package com.example.demostudentmanagement.service.impl;

import com.example.demostudentmanagement.dto.StudentDto;
import com.example.demostudentmanagement.dto.request.StudentUpdateDTo;
import com.example.demostudentmanagement.entity.Course;
import com.example.demostudentmanagement.entity.Student;
import com.example.demostudentmanagement.repo.StudentRepo;
import com.example.demostudentmanagement.service.StudentService;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public String saveStudent(StudentDto studentDto) {

        Student student=new Student(
                studentDto.getSid(),
                studentDto.getSname(),
                studentDto.getAddress()
        );
        studentRepo.save(student);

        return studentDto.getSname();

//        if (studentRepo.existsById(studentDto.getSid())) {
//            throw new EntityExistsException("Student with ID " + studentDto.getSid() + " already exists");
//        }
//
//
//        Student student = new Student();
//        student.setSid(studentDto.getSid());
//        student.setSname(studentDto.getSname());
//        student.setAddress(studentDto.getAddress());
//
//        studentRepo.save(student);
//
//        return studentDto.getSname();
    }

    @Override
    public String updateStudent(StudentUpdateDTo studentUpdateDTo) {

        if(studentRepo.existsById(studentUpdateDTo.getSid())){

            Student student=studentRepo.getReferenceById(studentUpdateDTo.getSid());
            student.setSname(studentUpdateDTo.getSname());
            student.setAddress(studentUpdateDTo.getAddress());
            studentRepo.save(student);
            return studentUpdateDTo.getSname();
        }
        else{
          throw new RuntimeException("no data found for that id");
        }

    }

    @Override
    public StudentDto getStudentById(int sid) {
        if(studentRepo.existsById(sid)){
            Student student=studentRepo.getReferenceById(sid);
            StudentDto studentDto=new StudentDto(
                    student.getSid(),
                    student.getSname(),
                    student.getAddress()
            );
            return studentDto;
        }else
        {
            throw new RuntimeException("no customer");
        }

    }

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student>getAllStudents=studentRepo.findAll();
        List<StudentDto>studentDtoList=new ArrayList<>();

        for (Student student : getAllStudents)
        {
            StudentDto studentDto=new StudentDto(
                    student.getSid(),
                    student.getSname(),
                    student.getAddress()
            );
            studentDtoList.add(studentDto);

        }

        return studentDtoList;
    }

  @Override
    public String deleteStudent(int sid) {
        if(studentRepo.existsById(sid)) {
            studentRepo.deleteById(sid);
            return "Deleted";

        }else{
            throw new RuntimeException("No student found");
        }


    }

}
