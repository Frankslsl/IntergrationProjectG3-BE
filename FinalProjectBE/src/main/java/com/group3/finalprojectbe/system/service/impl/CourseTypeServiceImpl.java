package com.group3.finalprojectbe.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.group3.finalprojectbe.system.dto.CourseTypeDTO;
import com.group3.finalprojectbe.system.entity.CourseTypeEntity;
import com.group3.finalprojectbe.system.excption.BizExceptionKit;
import com.group3.finalprojectbe.system.mapper.CourseTypeMapperHelper;
import com.group3.finalprojectbe.system.repo.CourseTypeRepository;
import com.group3.finalprojectbe.system.service.CourseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseTypeServiceImpl implements CourseTypeService {

    private final CourseTypeRepository courseTypeRepository;
    private final CourseTypeMapperHelper courseTypeMapperHelper;


    @Override
    public List<CourseTypeDTO> getAllTypes() {
        List<CourseTypeEntity> all = courseTypeRepository.findAll();
        boolean empty = CollectionUtil.isEmpty(all);
        if (empty) {
            throw BizExceptionKit.of("There is no Course Type can be found in database");
        } else {
            return all.stream().map(courseTypeMapperHelper::apply).collect(Collectors.toList());
        }

    }
}
