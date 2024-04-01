package com.example.demostudentmanagement.service;

import com.example.demostudentmanagement.dto.LectureDto;
import com.example.demostudentmanagement.dto.ModuleDto;
import com.example.demostudentmanagement.dto.request.ModuleUpdateDTo;

import java.util.List;

public interface ModuleService {

    public String saveModule(ModuleDto moduleDto);

    String updateModule(ModuleUpdateDTo moduleUpdateDTo);

    ModuleDto getModuleById(int mid);

    List<ModuleDto> getAllModules();

    String deleteModule(int mid);
}
