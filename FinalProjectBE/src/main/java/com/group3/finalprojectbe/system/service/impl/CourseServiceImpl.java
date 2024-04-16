package com.group3.finalprojectbe.system.service.impl;

import com.group3.finalprojectbe.system.dto.CourseDTO;
import com.group3.finalprojectbe.system.dto.CourseRegisterDTO;
import com.group3.finalprojectbe.system.entity.CourseEntity;
import com.group3.finalprojectbe.system.entity.User;
import com.group3.finalprojectbe.system.repo.CourseRepository;
import com.group3.finalprojectbe.system.repo.UserRepository;
import com.group3.finalprojectbe.system.service.CourseService;
import com.group3.finalprojectbe.system.service.CourseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseTypeService courseTypeService;




    @Override
    public CourseRegisterDTO addCourseRegister(Long courseId, Long userId) {

        if (courseRepository.findById(courseId).isPresent() && userRepository.findById(userId).isPresent()){
            CourseEntity selectedCourse = courseRepository.findById(courseId).get();
            User user = userRepository.findById(userId).get();
            List<User> students = selectedCourse.getStudents();
            if(!students.contains(user)){
                students.add(user);
            }
            selectedCourse.setStudents(students);
            CourseEntity save = courseRepository.save(selectedCourse);
            return courseRepository.getCourseRegister(courseId, userId);
        } else {
            throw new RuntimeException("Course or User not exist");
        }
    }
}
