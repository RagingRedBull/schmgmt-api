package com.example.sam.service;

import com.example.sam.mapper.SectionMapper;
import com.example.sam.model.dto.SectionDto;
import com.example.sam.model.entity.Section;
import com.example.sam.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;
    public Set<SectionDto> findAll() {
        return sectionMapper.toDto(sectionRepository.findAll());
    }
}
