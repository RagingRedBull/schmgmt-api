package com.example.sam.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "section")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 10)
    private String name;
    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
    @OrderBy("id")
    private Set<Student> students;
}
