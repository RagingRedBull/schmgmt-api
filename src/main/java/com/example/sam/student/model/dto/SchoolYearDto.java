package com.example.sam.student.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Getter
@Builder
@Jacksonized
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchoolYearDto {
    private int id;
    private String year;
    private Set<SectionDto> sectionDtos;
    private Set<SubjectScheduleDto> subjectScheduleDtos;
}
