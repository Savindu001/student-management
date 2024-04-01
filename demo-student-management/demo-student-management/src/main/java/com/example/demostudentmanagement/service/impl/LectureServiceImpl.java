package com.example.demostudentmanagement.service.impl;

import com.example.demostudentmanagement.dto.LectureDto;
import com.example.demostudentmanagement.dto.StudentDto;
import com.example.demostudentmanagement.dto.request.LectureUpdateDTo;
import com.example.demostudentmanagement.entity.Lecture;
import com.example.demostudentmanagement.entity.Student;
import com.example.demostudentmanagement.repo.LectureRepo;
import com.example.demostudentmanagement.repo.StudentRepo;
import com.example.demostudentmanagement.service.LectureService;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    @Autowired
    private LectureRepo lectureRepo;


    @Override
    public String saveLecture(LectureDto lectureDto) {
        Lecture lecture=new Lecture(
                lectureDto.getLid(),
                lectureDto.getLname(),
                lectureDto.getLaddress()
        );
        lectureRepo.save(lecture);
        return lectureDto.getLname();

//        if (lectureRepo.existsById(lectureDto.getLid())) {
//            throw new EntityExistsException("Lecture with ID " + lectureDto.getLid() + " already exists");
//        }
//
//
//        Lecture lecture = new Lecture();
//        lecture.setLid(lectureDto.getLid());
//        lecture.setLname(lectureDto.getLname());
//        lecture.setLaddress(lectureDto.getLaddress());
//
//        lectureRepo.save(lecture);
//
//        return lectureDto.getLname();
    }

    @Override
    public String updateLecture(LectureUpdateDTo lectureUpdateDTo) {

        if(lectureRepo.existsById(lectureUpdateDTo.getLid())){

            Lecture lecture=lectureRepo.getReferenceById(lectureUpdateDTo.getLid());
            lecture.setLname(lectureUpdateDTo.getLname());
            lecture.setLaddress(lectureUpdateDTo.getLaddress());
            lectureRepo.save(lecture);
            return lectureUpdateDTo.getLname();
        }
        else{
            throw new RuntimeException("no data found for that id");
        }

    }

    @Override
    public LectureDto getLectureById(int lid) {
        if(lectureRepo.existsById(lid)){
            Lecture lecture=lectureRepo.getReferenceById(lid);
            LectureDto lectureDto=new LectureDto(
                    lecture.getLid(),
                    lecture.getLname(),
                    lecture.getLaddress()
            );
            return lectureDto;
        }else
        {
            throw new RuntimeException("no customer");
        }
    }

    @Override
    public List<LectureDto> getAllLectures() {

        List<Lecture>getAlllectures=lectureRepo.findAll();
        List<LectureDto>lectureDtoList=new ArrayList<>();

        for (Lecture lecture : getAlllectures)
        {
            LectureDto lectureDto=new LectureDto(
                    lecture.getLid(),
                    lecture.getLname(),
                    lecture.getLaddress()
            );
            lectureDtoList.add(lectureDto);

        }

        return lectureDtoList;
    }

    @Override
    public String deleteLecture(int lid) {
        if(lectureRepo.existsById(lid)) {
            lectureRepo.deleteById(lid);
            return "Deleted";

        }else{
            throw new RuntimeException("No student found");
        }


    }
    }



