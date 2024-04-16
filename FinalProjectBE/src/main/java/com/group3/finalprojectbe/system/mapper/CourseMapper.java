package com.group3.finalprojectbe.system.mapper;

import com.group3.finalprojectbe.system.dto.CourseDTO;
import com.group3.finalprojectbe.system.entity.CourseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@RequiredArgsConstructor
public class CourseMapper implements Function<CourseEntity, CourseDTO> {
    private final UserMapper userMapper;
    @Override
    public CourseDTO apply(CourseEntity course) {
        return new CourseDTO((course.getId()), course.getStartDate(), course.getTime(), course.getTypeLinked(), course.getStudents().stream().map(userMapper::apply).toList());
    }
}
