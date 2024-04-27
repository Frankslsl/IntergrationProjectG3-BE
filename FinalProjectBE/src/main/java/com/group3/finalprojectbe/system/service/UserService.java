package com.group3.finalprojectbe.system.service;

import com.group3.finalprojectbe.system.dto.LoginRequest;
import com.group3.finalprojectbe.system.dto.RegisterRequest;
import com.group3.finalprojectbe.system.dto.UserDto;
import com.group3.finalprojectbe.system.entity.CourseEntity;
import com.group3.finalprojectbe.system.entity.User;

import java.util.List;

public interface UserService {
    public String registerUser(RegisterRequest registerRequest);

    List<User> getAllUser();

    String loginUser(LoginRequest loginRequest);

    UserDto getUserById(Long id);

    String editUser(Long userId, RegisterRequest user);

    List<CourseEntity> getCourseByUserId(Long id);

    void addCourseToUser(Long userId, Long courseId);
    void deleteCourseByUser(Long userId, Long courseId);

}
