package com.example.demostudentmanagement.service.impl;

import com.example.demostudentmanagement.dto.LectureDto;
import com.example.demostudentmanagement.dto.ModuleDto;
import com.example.demostudentmanagement.dto.request.ModuleUpdateDTo;
import com.example.demostudentmanagement.entity.Course;
import com.example.demostudentmanagement.entity.Lecture;
import com.example.demostudentmanagement.entity.Module;
import com.example.demostudentmanagement.repo.ModuleRepo;
import com.example.demostudentmanagement.service.ModuleService;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

  @Autowired
  private ModuleRepo moduleRepo;
    @Override
    public String saveModule(ModuleDto moduleDto) {
        Module module=new Module(
                moduleDto.getMid(),
                moduleDto.getMname()
        );
        moduleRepo.save(module);
     return moduleDto.getMname();


//        if (moduleRepo.existsById(moduleDto.getMid())) {
//            throw new EntityExistsException("Module with ID " + moduleDto.getMid() + " already exists");
//        }
//
//
//        Module module = new Module();
//        module.setMid(moduleDto.getMid());
//        module.setMname(moduleDto.getMname());
//
//        moduleRepo.save(module);
//
//        return moduleDto.getMname();
    }

    @Override
    public String updateModule(ModuleUpdateDTo moduleUpdateDTo) {
        if(moduleRepo.existsById(moduleUpdateDTo.getMid())){

            Module module=moduleRepo.getReferenceById(moduleUpdateDTo.getMid());
            module.setMname(moduleUpdateDTo.getMname());

            moduleRepo.save(module);
            return moduleUpdateDTo.getMname();
        }
        else{
            throw new RuntimeException("no data found for that id");
        }
    }

    @Override
    public ModuleDto getModuleById(int mid) {
        if(moduleRepo.existsById(mid)){
            Module module=moduleRepo.getReferenceById(mid);
            ModuleDto moduleDto=new ModuleDto(
                    module.getMid(),
                    module.getMname()

            );
            return moduleDto;
        }else
        {
            throw new RuntimeException("no customer");
        }
    }

    @Override
    public List<ModuleDto> getAllModules() {
        List<Module>getAllmodules=moduleRepo.findAll();
        List<ModuleDto>moduleDtoList=new ArrayList<>();

        for (Module module : getAllmodules)
        {
            ModuleDto moduleDto=new ModuleDto(
                    module.getMid(),
                    module.getMname()

            );
            moduleDtoList.add(moduleDto);

        }

        return moduleDtoList;
    }

    @Override
    public String deleteModule(int mid) {

        if(moduleRepo.existsById(mid)) {
            moduleRepo.deleteById(mid);
            return "Deleted";

        }else{
            throw new RuntimeException("No student found");
        }

    }
}
