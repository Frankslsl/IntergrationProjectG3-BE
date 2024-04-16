package com.group3.finalprojectbe.system.dto;

import com.group3.finalprojectbe.system.entity.CourseTypeEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Builder
//public class CourseDTO {
//    private Long id;
//    @NotEmpty
//    @NotBlank
//    private String name;
//    private String startDate;
//
//    private String time;
//}
public record CourseDTO(Long id, @NotNull LocalDate startDate, String duration, CourseTypeDTO courseType,
                        List<UserDto> students) implements Serializable {
}
