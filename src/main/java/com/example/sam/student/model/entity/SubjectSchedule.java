package com.example.sam.student.model.entity;

import com.example.sam.student.model.entity.id.SubjectScheduleId;
import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity(name = "subject_schedule")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectSchedule {
    @EmbeddedId
    private SubjectScheduleId subjectScheduleId;
    @Column(name = "time_start")
    private LocalTime timeStart;
    @Column(name = "time_end")
    private LocalTime timeEnd;
    @Column(name = "day")
    @Enumerated(EnumType.ORDINAL)
    private DayOfWeek day;
    @ManyToOne
    @MapsId("sectionId")
    @JoinColumn(name = "section_id")
    private Section section;
    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @MapsId("schoolYearId")
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;
}
