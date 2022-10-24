package com.example.sam.service;

import com.example.sam.mapper.StudentMapper;
import com.example.sam.model.dto.StudentDto;
import com.example.sam.model.entity.Student;
import com.example.sam.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    public StudentDto findById(Integer id) {
        return studentMapper.toDto(studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid ids")));
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
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
