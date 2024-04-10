package com.group3.finalprojectbe.system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String startDate;

    private String time;

    @ManyToOne
    @JoinColumn(name="typeId", nullable=false)
    private CourseTypeEntity typeLinked;

//    @ManyToMany(mappedBy="selectedCourse", cascade = CascadeType.ALL)
//    private List<User> students;
}
