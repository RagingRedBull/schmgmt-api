package com.example.sam.student.service;

import com.example.sam.student.mapper.SectionMapper;
import com.example.sam.student.model.dto.SectionDto;
import com.example.sam.student.model.entity.Section;
import com.example.sam.student.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Log4j2
@RequiredArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;
    public Set<SectionDto> findAll() {
        return sectionMapper.toDto(sectionRepository.findAll());
    }
    @Transactional
    public Set<SectionDto> findAllBySchoolYearId(Integer schoolYearId) {
        try(Stream<Section> sectionStream = sectionRepository.findSectionBySchoolYearId(schoolYearId)) {
            return sectionStream.map(sectionMapper::toDto)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return new LinkedHashSet<>();
    }
    public SectionDto findById(Integer id) {
        return sectionMapper.toDto(sectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No id found")));
    }
}
