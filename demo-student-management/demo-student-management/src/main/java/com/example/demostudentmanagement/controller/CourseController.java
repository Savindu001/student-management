package com.example.demostudentmanagement.controller;


import com.example.demostudentmanagement.dto.CourseDto;
import com.example.demostudentmanagement.dto.LectureDto;
import com.example.demostudentmanagement.dto.request.CourseUpdateDTo;
import com.example.demostudentmanagement.service.CourseService;
import com.example.demostudentmanagement.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public String saveCourse(@RequestBody CourseDto courseDto){
        courseService.saveCourse(courseDto);

        return "saved";
    }

    @PutMapping("/update")
    public String updateCourse(@RequestBody CourseUpdateDTo courseUpdateDTo){
       courseService.updateCourse(courseUpdateDTo);

        return "updated";
    }

//
//    @GetMapping(
//            path="get-by-id",
//            params="id"
//    )
//
//    public CourseDto getCourseById(@RequestParam(value="id")int cid){
//        CourseDto courseDto=courseService.getCourseById(cid);
//        return  courseDto;
//
//    }

    @GetMapping(
            path="/get-all-courses"
    )

    public List<CourseDto> getAllCourses()
    {
        List<CourseDto>allcourses=courseService.getAllcourses();
        return allcourses;
    }

    @DeleteMapping(

            path="/delete-course/{id}"
    )

    public String deleteCourse(@PathVariable(value = "id") int cid){
        String deleted=courseService.deleteCourse(cid);
        return deleted;
    }






}
