package com.example.sam.student.repository;

import com.example.sam.student.model.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface StudentRepository extends SamJpaRepository<Student, Integer> {
    @Query(value = "SELECT s from student s")
    Stream<Student> findAllAsStream();
}
