package com.example.sam.student.repository;

import com.example.sam.student.model.entity.SubjectSchedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SubjectScheduleRepository extends SamJpaRepository<SubjectSchedule, Integer> {
    @Query(value = "SELECT s FROM subject_schedule s")
    Stream<SubjectSchedule> findAllAsStream();

    @Query(value = "SELECT s FROM subject_schedule s" +
            " WHERE s.subjectScheduleId.subjectId=?1" +
            " AND s.subjectScheduleId.schoolYearId=?2")
    Stream<SubjectSchedule> findAllBySubjectAndYear(Integer subjectId, Integer schoolYearId);

    @Query(value = "SELECT s FROM subject_schedule s" +
            " WHERE s.subjectScheduleId.schoolYearId=?1")
    Stream<SubjectSchedule> findAllByYear(Integer schoolYearId);
}
