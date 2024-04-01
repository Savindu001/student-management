package com.example.demostudentmanagement.controller;


import com.example.demostudentmanagement.dto.LectureDto;
import com.example.demostudentmanagement.dto.StudentDto;
import com.example.demostudentmanagement.dto.request.LectureUpdateDTo;
import com.example.demostudentmanagement.service.LectureService;
import com.example.demostudentmanagement.service.StudentService;
import com.example.demostudentmanagement.service.impl.LectureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/lecture")
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @PostMapping("/save")
    public String saveLecture(@RequestBody LectureDto lectureDto){
        lectureService.saveLecture(lectureDto);
        return "saved";
    }

    @PutMapping("/update")
    public String updateLecture(@RequestBody LectureUpdateDTo lectureUpdateDTo){
        lectureService.updateLecture(lectureUpdateDTo);
        return "updated";
    }
//
//    @GetMapping(
//            path="get-by-id",
//            params="id"
//    )
//
//    public LectureDto getLectureById(@RequestParam(value="id")int Lid){
//        LectureDto lectureDto=lectureService.getLectureById(Lid);
//        return  lectureDto;
//
//    }

    @GetMapping(
            path="/get-all-lectures"
    )

    public List<LectureDto> getAllLectures()
    {
        List<LectureDto>alllectures=lectureService.getAllLectures();
        return alllectures;
    }

    @DeleteMapping(

            path="/delete-lecture/{id}"
    )

    public String deleteLecture(@PathVariable(value = "id") int Lid){
        String deleted=lectureService.deleteLecture(Lid);
        return deleted;
    }





}
