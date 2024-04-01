package com.example.demostudentmanagement.controller;

import com.example.demostudentmanagement.dto.LectureDto;
import com.example.demostudentmanagement.dto.ModuleDto;
import com.example.demostudentmanagement.dto.request.ModuleUpdateDTo;
import com.example.demostudentmanagement.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping("/save")
    public String saveModule(@RequestBody ModuleDto moduleDto) {
        moduleService.saveModule(moduleDto);
        return "saved";
    }

    @PutMapping("/update")
    public String updateModule(@RequestBody ModuleUpdateDTo moduleUpdateDTo) {
        moduleService.updateModule(moduleUpdateDTo);

        return "updated";
    }

//    @GetMapping(
//            path="get-by-id",
//            params="id"
//    )
//
//    public ModuleDto getModuleById(@RequestParam(value="id")int mid){
//        ModuleDto moduleDto=moduleService.getModuleById(mid);
//        return  moduleDto;
//
//    }

    @GetMapping(
            path="/get-all-modules"
    )

    public List<ModuleDto> getAllModules()
    {
        List<ModuleDto>allmodules=moduleService.getAllModules();
        return allmodules;
    }

    @DeleteMapping(

            path="/delete-module/{id}"
    )

    public String deleteModule(@PathVariable(value = "id") int mid){
        String deleted=moduleService.deleteModule(mid);
        return deleted;
    }


}
