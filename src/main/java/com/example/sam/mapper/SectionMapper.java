package com.example.sam.mapper;

import com.example.sam.model.dto.SectionDto;
import com.example.sam.model.entity.Section;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface SectionMapper {
    @Mapping(target = "students", source = "dto.studentDtos")
    Section toEntity(SectionDto dto);
    @Mapping(target = "studentDtos", source = "section.students")
    SectionDto toDto(Section section);

    Set<Section> toEntity(Collection<SectionDto> dtos);

    Set<SectionDto> toDto(Collection<Section> entites);
}
