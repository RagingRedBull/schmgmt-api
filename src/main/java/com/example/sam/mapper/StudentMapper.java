package com.example.sam.mapper;

import com.example.sam.model.dto.StudentDto;
import com.example.sam.model.entity.Student;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentDto dto);
    StudentDto toDto(Student student);
    Set<Student> toEntity(Collection<StudentDto> dtos);
    Set<StudentDto> toDto(Collection<Student> students);
}
