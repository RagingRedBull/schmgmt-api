package com.example.sam.student.service;

import com.example.sam.student.mapper.SubjectMapper;
import com.example.sam.student.model.dto.SubjectDto;
import com.example.sam.student.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;
    public SubjectDto findById(Integer subjectId) {
        return subjectMapper.toDto(subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Invalid id")));
    }
}
