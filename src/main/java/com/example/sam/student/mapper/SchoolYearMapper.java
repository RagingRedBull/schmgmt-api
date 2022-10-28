package com.example.sam.student.mapper;

import com.example.sam.student.model.dto.SchoolYearDto;
import com.example.sam.student.model.entity.SchoolYear;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SchoolYearMapper {
    @Mapping(target = "sectionSet", ignore = true)
    @Mapping(target = "subjectSchedules", ignore = true)
    SchoolYear toEntity(SchoolYearDto schoolYearDto);

    @Mapping(target = "sectionDtos", ignore = true)
    @Mapping(target = "subjectScheduleDtos", ignore = true)
    SchoolYearDto toDto(SchoolYear schoolYear);
}
