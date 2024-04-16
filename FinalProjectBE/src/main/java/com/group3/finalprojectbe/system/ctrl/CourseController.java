package com.group3.finalprojectbe.system.ctrl;

import com.group3.finalprojectbe.system.dto.CourseDTO;
import com.group3.finalprojectbe.system.dto.CourseRegisterDTO;
import com.group3.finalprojectbe.system.service.CourseService;
import com.group3.finalprojectbe.system.service.CourseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CourseTypeService courseTypeService;



    @GetMapping("/safe/allCoursesByTypeId/{courseTypeId}")
    public ResponseEntity<List<CourseDTO>> getAllCoursesByTypeId(@PathVariable("courseTypeId") Long courseTypeId){
        List<CourseDTO> courseByTypeId = courseTypeService.getCoursesByTypeId(courseTypeId);

        return ResponseEntity.ok(courseByTypeId);
    }

    @PostMapping("/courseRegister")
    public ResponseEntity<CourseRegisterDTO> selectCourse(@RequestBody CourseRegisterDTO courseRegister){
        try {
            CourseRegisterDTO result = courseService.addCourseRegister(courseRegister.getCourseId(), courseRegister.getUserId());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
