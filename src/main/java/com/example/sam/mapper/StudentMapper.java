package com.example.sam.mapper;

import com.example.sam.model.dto.StudentDto;
import com.example.sam.model.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements Mapper<Student, StudentDto> {

    public StudentDto toDto(Student e) {
        return StudentDto.builder()
                .id(e.getId())
                .internalId(e.getInternalId())
                .firstName(e.getFirstName())
                .lastName(e.getLastName())
                .birthday(e.getBirthday())
                .build();
    }

    public Student toEntity(StudentDto studentDto) {
        return Student.builder()
                .id(studentDto.getId())
                .internalId(studentDto.getInternalId())
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .birthday(studentDto.getBirthday())
                .build();
    }
}
