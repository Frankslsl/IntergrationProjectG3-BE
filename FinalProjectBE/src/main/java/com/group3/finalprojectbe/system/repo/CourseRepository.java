package com.group3.finalprojectbe.system.repo;

import com.group3.finalprojectbe.system.dto.CourseDTO;
import com.group3.finalprojectbe.system.dto.CourseRegisterDTO;
import com.group3.finalprojectbe.system.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    @Query("select new com.group3.finalprojectbe.system.dto.CourseDTO (c.id, t.name, c.startDate, c.duration) " +
            "from CourseEntity c ,CourseTypeEntity t  where c.typeLinked.id=t.id and t.id = :typeId")
    List<CourseDTO> findByTypeId(Long typeId);

    @Query("select new com.group3.finalprojectbe.system.dto.CourseRegisterDTO (u.id, c.id) " +
            "from CourseEntity c ,User u  where c.id = :courseId and u.id = :userId")
    CourseRegisterDTO getCourseRegister(@Param("userId")Long userId, @Param("courseId")Long courseId);

}
