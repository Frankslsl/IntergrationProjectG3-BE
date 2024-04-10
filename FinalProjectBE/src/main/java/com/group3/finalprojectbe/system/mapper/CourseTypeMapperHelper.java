package com.group3.finalprojectbe.system.mapper;

import com.group3.finalprojectbe.system.dto.CourseTypeDTO;
import com.group3.finalprojectbe.system.entity.CourseTypeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseTypeMapperHelper {

    //private final ObjectMapper mapper;
    public List<CourseTypeDTO> convertAuthorEntityListToAuthorList(List<CourseTypeEntity> courseTypeEntities) {
        List<CourseTypeDTO> courseTypeDTOS = new ArrayList<>();
        for (CourseTypeEntity temp: courseTypeEntities){
            CourseTypeDTO courseTypeDTO = CourseTypeDTO.builder().id(temp.getId()).name(temp.getName()).description(temp.getDescription()).image(temp.getImage()).build();
            courseTypeDTOS.add(courseTypeDTO);
        }
        return courseTypeDTOS;
    }
}
