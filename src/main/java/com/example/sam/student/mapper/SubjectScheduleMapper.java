package com.example.sam.student.mapper;

import com.example.sam.student.model.dto.SubjectScheduleDto;
import com.example.sam.student.model.entity.SubjectSchedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectScheduleMapper {
    SubjectSchedule toEntity(SubjectScheduleDto subjectScheduleDto);
    SubjectScheduleDto toDto(SubjectSchedule subjectSchedule);
}
