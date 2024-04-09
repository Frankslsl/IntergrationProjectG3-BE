package com.group3.finalprojectbe.system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "course_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name", unique = true)
    @NotNull
    private String name;

    @NotBlank
    private String description;

    @Column(nullable = false)
    @NotNull
    private String image;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="typeLinked")
    private List<CourseEntity> courses;
}
