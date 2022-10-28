package com.example.sam.student.service;

import com.example.sam.student.exception.InvalidSearchKeyException;
import com.example.sam.student.mapper.SchoolYearMapper;
import com.example.sam.student.model.dto.SchoolYearDto;
import com.example.sam.student.repository.SchoolYearRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SchoolYearService {
    private final SchoolYearMapper schoolYearMapper;
    private final SchoolYearRepository schoolYearRepository;
    public SchoolYearDto findByYear(String schoolYear) {
        return schoolYearMapper.toDto(schoolYearRepository.findByYear(schoolYear)
                .orElseThrow(() -> new InvalidSearchKeyException("Invalid school year searched!")));
    }
}
