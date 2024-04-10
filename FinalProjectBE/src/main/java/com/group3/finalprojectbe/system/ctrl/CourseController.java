package com.group3.finalprojectbe.system.ctrl;

import com.google.gson.Gson;
import com.group3.finalprojectbe.system.dto.CourseDTO;
import com.group3.finalprojectbe.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/course")
    public String getCourse(@RequestParam("Id") Long typeId){
        List<CourseDTO> courseByTypeId = service.getCoursesByTypeId(typeId);
        return new Gson().toJson(courseByTypeId);
    }
}
