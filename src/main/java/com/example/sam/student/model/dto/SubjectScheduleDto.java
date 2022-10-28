package com.example.sam.student.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@Jacksonized
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectScheduleDto {
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private String day;
    @JsonProperty(value = "section")
    private SectionDto sectionDto;
    @JsonProperty(value = "subject")
    private SubjectDto subjectDto;
    @JsonProperty(value = "schoolYear")
    private SchoolYearDto schoolYearDto;
}
