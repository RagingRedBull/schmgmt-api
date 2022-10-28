package com.example.sam.student.service;

import com.example.sam.student.mapper.StudentMapper;
import com.example.sam.student.model.dto.StudentDto;
import com.example.sam.student.model.entity.Student;
import com.example.sam.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    public StudentDto findById(Integer id) {
        return studentMapper.toDto(studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid ids")));
    }

    public Set<StudentDto> findAll() {
        try(Stream<Student> studentStream = studentRepository.findAllAsStream()) {
            return studentStream.map(studentMapper::toDto)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }
    }

    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public StudentDto saveOne(StudentDto dto) {
        return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(dto)));
    }

    public List<Student> saveAll(List<Student> students) {
        return studentRepository.saveAll(students);
    }
}
