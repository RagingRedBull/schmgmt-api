package com.example.sam.student.mapper;

import com.example.sam.student.model.dto.SubjectDto;
import com.example.sam.student.model.entity.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    Subject toEntity(SubjectDto subjectDto);
    SubjectDto toDto(Subject subject);
}
