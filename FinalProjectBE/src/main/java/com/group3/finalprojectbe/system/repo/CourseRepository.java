package com.group3.finalprojectbe.system.repo;

import com.group3.finalprojectbe.system.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
