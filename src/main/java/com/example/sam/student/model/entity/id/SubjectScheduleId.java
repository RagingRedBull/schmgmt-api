package com.example.sam.student.model.entity.id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SubjectScheduleId implements Serializable {
    @Column(name = "section_id")
    private Integer sectionId;
    @Column(name = "subject_id")
    private Integer subjectId;
    @Column(name = "school_year_id")
    private Integer schoolYearId;
}
