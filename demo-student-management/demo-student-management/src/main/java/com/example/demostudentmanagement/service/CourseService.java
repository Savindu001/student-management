package com.example.demostudentmanagement.service;

import com.example.demostudentmanagement.dto.CourseDto;
import com.example.demostudentmanagement.dto.LectureDto;
import com.example.demostudentmanagement.dto.request.CourseUpdateDTo;

import java.util.List;

public interface CourseService {


    public String saveCourse(CourseDto courseDto);


    String updateCourse(CourseUpdateDTo courseUpdateDTo);

    CourseDto getCourseById(int cid);

    List<CourseDto> getAllcourses();

    String deleteCourse(int cid);
}
