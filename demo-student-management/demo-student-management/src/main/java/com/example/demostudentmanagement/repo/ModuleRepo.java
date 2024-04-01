package com.example.demostudentmanagement.repo;

import com.example.demostudentmanagement.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ModuleRepo extends JpaRepository<Module,Integer> {

}
