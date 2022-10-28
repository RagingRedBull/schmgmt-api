package com.example.sam.student.mapper;

import com.example.sam.student.model.dto.StudentDto;
import com.example.sam.student.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "section", ignore = true)
    Student toEntity(StudentDto dto);

    StudentDto toDto(Student student);

    Set<Student> toEntity(Collection<StudentDto> dtos);

    Set<StudentDto> toDto(Collection<Student> students);
}
