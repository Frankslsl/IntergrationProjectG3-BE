package com.group3.finalprojectbe.system.mapper;

import cn.hutool.core.codec.Base64;
import com.group3.finalprojectbe.system.dto.CourseTypeDTO;
import com.group3.finalprojectbe.system.entity.CourseTypeEntity;
import com.group3.finalprojectbe.system.excption.BizException;
import com.group3.finalprojectbe.system.excption.BizExceptionKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.function.Function;

@Component
@Slf4j
public class CourseTypeMapperHelper implements Function<CourseTypeEntity, CourseTypeDTO> {

    @Override
    public CourseTypeDTO apply(CourseTypeEntity courseTypeEntity) {
        Blob image = courseTypeEntity.getImage();
        String imageBase64Str = null;
        if(image != null){
            try{
                imageBase64Str = Base64.encode(image.getBytes(1,(int)image.length()));
            }catch (Exception e){
                throw BizExceptionKit.of("Error when retrieving image");
            }finally {
                try {
                    image.free();
                }catch (SQLException e){
                    log.warn("Failed to free Blob resources: " + e.getMessage());
                }
            }
        }
        return CourseTypeDTO.builder()
                .id(courseTypeEntity.getId())
                .name(courseTypeEntity.getName())
                .description(courseTypeEntity.getDescription())
                .image(imageBase64Str)
                .build();
    }
}
