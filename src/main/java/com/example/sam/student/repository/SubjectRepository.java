package com.example.sam.student.repository;

import com.example.sam.student.model.entity.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SubjectRepository extends SamJpaRepository<Subject, Integer>{
    @Query(value = "SELECT s FROM subject s" +
            " JOIN s.subjectSchedules sched" +
            " WHERE sched.subjectScheduleId.schoolYearId=?1" +
            " AND sched.subjectScheduleId.sectionId=?2")
    Stream<Subject> findAllBySchedule(Integer schoolYearId,
                                      Integer sectionId);

}
