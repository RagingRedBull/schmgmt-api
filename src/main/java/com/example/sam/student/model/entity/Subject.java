package com.example.sam.student.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "subject")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "code", length = 10)
    private String code;
    @OneToMany(mappedBy = "subject")
    Set<SubjectSchedule> subjectSchedules;
}
