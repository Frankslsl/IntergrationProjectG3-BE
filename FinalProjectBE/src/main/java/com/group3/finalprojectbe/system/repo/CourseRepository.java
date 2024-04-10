package com.group3.finalprojectbe.system.repo;

import com.group3.finalprojectbe.system.dto.CourseDTO;
import com.group3.finalprojectbe.system.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    @Query("select new com.group3.finalprojectbe.system.dto.CourseDTO (c.id, t.name, c.startDate, c.time) " +
            "from CourseEntity c ,CourseTypeEntity t  where c.typeLinked.id=t.id")
    List<CourseDTO> findByTypeId(Long typeId);
}
