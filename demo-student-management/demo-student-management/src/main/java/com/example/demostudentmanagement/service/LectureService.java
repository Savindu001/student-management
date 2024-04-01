package com.example.demostudentmanagement.service;

import com.example.demostudentmanagement.dto.LectureDto;
import com.example.demostudentmanagement.dto.StudentDto;
import com.example.demostudentmanagement.dto.request.LectureUpdateDTo;

import java.util.List;

public interface LectureService  {

    public String saveLecture(LectureDto lectureDto);


    String updateLecture(LectureUpdateDTo lectureUpdateDTo);

    LectureDto getLectureById(int lid);

    List<LectureDto> getAllLectures();

    String deleteLecture(int lid);
}
