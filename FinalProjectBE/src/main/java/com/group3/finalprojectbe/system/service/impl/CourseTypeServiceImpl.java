package com.group3.finalprojectbe.system.service.impl;

import com.group3.finalprojectbe.system.entity.CourseTypeEntity;
import com.group3.finalprojectbe.system.repo.CourseTypeRepository;
import com.group3.finalprojectbe.system.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    private final CourseTypeRepository courseTypeRepository;

    @Autowired
    public CourseTypeServiceImpl(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }

    @Override
    public List<CourseTypeEntity> getAllTypes() {
        return courseTypeRepository.findAll();
    }
}
