package com.group3.finalprojectbe.system.ctrl;

import com.google.gson.Gson;
import com.group3.finalprojectbe.system.dto.CourseTypeDTO;
import com.group3.finalprojectbe.system.entity.CourseTypeEntity;
import com.group3.finalprojectbe.system.mapper.CourseTypeMapperHelper;
import com.group3.finalprojectbe.system.service.CourseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/courseType")
public class CourseTypeController {

    private final CourseTypeService service;
    private final CourseTypeMapperHelper mapperHelper;

    @Autowired
    public CourseTypeController(CourseTypeService service, CourseTypeMapperHelper mapperHelper) {
        this.service = service;
        this.mapperHelper =mapperHelper;
    }

    @GetMapping("/courseTypes")
    public ResponseEntity<List<CourseTypeDTO>> getCourseType(){
        List<CourseTypeEntity> courseTypeEntities = service.getAllTypes();
        List<CourseTypeDTO> courseTypeDTOS = mapperHelper.convertAuthorEntityListToAuthorList(courseTypeEntities);
        return ResponseEntity.ok(courseTypeDTOS);
    }
}
