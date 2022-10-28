package com.example.sam.student.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "school_year")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "year", length = 4, unique = true)
    private String year;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schoolYear")
    private Set<Section> sectionSet;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "schoolYear")
    private Set<SubjectSchedule> subjectSchedules;
}
