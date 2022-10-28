package com.example.sam.student.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "student")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "internal_id", length = 10)
    private String internalId;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 15)
    private String lastName;
    @Column(name = "birthday")
    private LocalDate birthday;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
}
