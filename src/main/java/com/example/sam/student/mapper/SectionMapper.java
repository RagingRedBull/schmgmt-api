package com.example.sam.student.mapper;

import com.example.sam.student.model.dto.SectionDto;
import com.example.sam.student.model.entity.Section;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface SectionMapper {
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "subjectSchedules", ignore = true)
    Section toEntity(SectionDto dto);
    @Mapping(target = "studentDtos", ignore = true)
    SectionDto toDto(Section section);
    Set<Section> toEntity(Collection<SectionDto> dtos);

    Set<SectionDto> toDto(Collection<Section> entites);
}
