package com.group3.finalprojectbe.system.service;

import com.group3.finalprojectbe.system.dto.CourseTypeDTO;
import com.group3.finalprojectbe.system.entity.CourseTypeEntity;

import java.util.List;

public interface CourseTypeService {

    List<CourseTypeDTO> getAllTypes();
}
