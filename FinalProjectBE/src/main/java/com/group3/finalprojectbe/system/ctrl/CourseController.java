package com.group3.finalprojectbe.system.ctrl;

import com.google.gson.Gson;
import com.group3.finalprojectbe.system.dto.CourseDTO;
import com.group3.finalprojectbe.system.dto.CourseRegisterDTO;
import com.group3.finalprojectbe.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin
public class CourseController {
    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/course")
    public ResponseEntity<List<CourseDTO>> getCourse(@RequestParam("Id") Long typeId){
        List<CourseDTO> courseByTypeId = service.getCoursesByTypeId(typeId);

        return ResponseEntity.ok(courseByTypeId);
    }

    @PostMapping("/courseRegister")
    public ResponseEntity<CourseRegisterDTO> selectCourse(@RequestBody CourseRegisterDTO courseRegister){
        try {
            CourseRegisterDTO result = service.addCourseRegister(courseRegister.getCourseId(), courseRegister.getUserId());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
