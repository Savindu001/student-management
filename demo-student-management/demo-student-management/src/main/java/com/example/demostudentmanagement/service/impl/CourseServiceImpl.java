package com.example.demostudentmanagement.service.impl;

import com.example.demostudentmanagement.dto.CourseDto;
import com.example.demostudentmanagement.dto.LectureDto;
import com.example.demostudentmanagement.dto.request.CourseUpdateDTo;
import com.example.demostudentmanagement.entity.Course;
import com.example.demostudentmanagement.entity.Lecture;
import com.example.demostudentmanagement.repo.CourseRepo;
import com.example.demostudentmanagement.service.CourseService;
import com.example.demostudentmanagement.service.LectureService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String saveCourse(CourseDto courseDto) {
        Course course=new Course(
                courseDto.getCid(),
                courseDto.getCname()

        );
        courseRepo.save(course);
        return courseDto.getCname();

//        if (courseRepo.existsById(courseDto.getCid())) {
//            throw new EntityExistsException("Course with ID " + courseDto.getCid() + " already exists");
//        }
//
//
//        Course course = new Course();
//        course.setCid(courseDto.getCid());
//        course.setCname(courseDto.getCname());
//
//        courseRepo.save(course);
//
//        return courseDto.getCname();
    }

    @Override
    public String updateCourse(CourseUpdateDTo courseUpdateDTo) {
//        if(courseRepo.existsById(courseUpdateDTo.getCid())){
//
//            Course course=courseRepo.getReferenceById(courseUpdateDTo.getCid());
//            course.setCname(courseUpdateDTo.getCname());
//
//            courseRepo.save(course);
//          return courseUpdateDTo.getCname();
//        }
//        else{
//           // throw new EntityNotFoundException("Course not found with ID: " + courseUpdateDTo.getCid());
//            throw new RuntimeException("no data found for that id");
//        }


        if (courseRepo.existsById(courseUpdateDTo.getCid())) {
            // Fetch the existing course
            Course course = courseRepo.findById(courseUpdateDTo.getCid())
                    .orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + courseUpdateDTo.getCid()));
            // Update the course details
            course.setCname(courseUpdateDTo.getCname());
            // Save the updated course
            courseRepo.save(course);
            return courseUpdateDTo.getCname(); // Return the updated course name
        } else {
            // If the course with the given ID doesn't exist, throw an exception
            throw new EntityNotFoundException("Course not found with ID: " + courseUpdateDTo.getCid());
        }


    }

    @Override
    public CourseDto getCourseById(int cid) {
        if(courseRepo.existsById(cid)){
            Course course=courseRepo.getReferenceById(cid);
            CourseDto courseDto=new CourseDto(
                    course.getCid(),
                    course.getCname()

            );
            return courseDto;
        }else
        {
            throw new RuntimeException("no customer");
        }
    }

    @Override
    public List<CourseDto> getAllcourses() {
        List<Course>getAllcourses=courseRepo.findAll();
        List<CourseDto>courseDtoList=new ArrayList<>();

        for (Course course : getAllcourses)
        {
            CourseDto courseDto=new CourseDto(
                    course.getCid(),
                    course.getCname()

            );
            courseDtoList.add(courseDto);

        }

        return courseDtoList;
    }

    @Override
    public String deleteCourse(int cid) {
        if(courseRepo.existsById(cid)) {
            courseRepo.deleteById(cid);
            return "Deleted";

        }else{
            throw new RuntimeException("No student found");
        }

    }
}
