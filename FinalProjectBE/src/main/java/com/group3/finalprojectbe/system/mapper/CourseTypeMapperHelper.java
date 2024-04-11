package com.group3.finalprojectbe.system.mapper;

import com.group3.finalprojectbe.system.dto.CourseTypeDTO;
import com.group3.finalprojectbe.system.entity.CourseTypeEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CourseTypeMapperHelper implements Function<CourseTypeEntity, CourseTypeDTO> {

    @Override
    public CourseTypeDTO apply(CourseTypeEntity courseTypeEntity) {
        return CourseTypeDTO.builder()
                .id(courseTypeEntity.getId())
                .name(courseTypeEntity.getName())
                .description(courseTypeEntity.getDescription())
                .image(courseTypeEntity.getImage())
                .build();
    }
}
