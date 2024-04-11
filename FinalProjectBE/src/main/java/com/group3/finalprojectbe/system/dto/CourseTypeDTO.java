package com.group3.finalprojectbe.system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseTypeDTO {

    private Long id;
    @NotEmpty
    @NotBlank
    private String name;

    private String description;
    @NotEmpty
    @NotBlank
    private String image;
}
