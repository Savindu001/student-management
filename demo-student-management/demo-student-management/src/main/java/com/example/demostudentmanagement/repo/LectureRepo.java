package com.example.demostudentmanagement.repo;

import com.example.demostudentmanagement.entity.Lecture;
import com.example.demostudentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LectureRepo extends JpaRepository<Lecture,Integer> {
}
