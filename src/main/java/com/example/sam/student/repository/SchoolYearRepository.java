package com.example.sam.student.repository;

import com.example.sam.student.model.entity.SchoolYear;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolYearRepository extends SamJpaRepository<SchoolYear, Integer> {
    @Query(value = "SELECT sy FROM school_year sy" +
            " WHERE sy.year = ?1")
    Optional<SchoolYear> findByYear(String year);
}
