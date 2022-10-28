package com.example.sam.student.repository;

import com.example.sam.student.model.entity.Section;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SectionRepository extends SamJpaRepository<Section, Integer>{
    @Query(value = "SELECT s FROM section s WHERE s.schoolYear.id=?1")
    Stream<Section> findSectionBySchoolYearId(Integer schoolYear);
}
