package com.example.sam.repository;

import com.example.sam.model.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends SamJpaRepository<Student, Integer> {

}
