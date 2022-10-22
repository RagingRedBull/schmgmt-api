package com.example.sam.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "student")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "section")
    private Set<Student> students;
}
