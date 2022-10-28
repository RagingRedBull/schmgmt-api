package com.example.sam.student.service;

import com.example.sam.student.mapper.SubjectScheduleMapper;
import com.example.sam.student.model.dto.SubjectScheduleDto;
import com.example.sam.student.model.entity.SubjectSchedule;
import com.example.sam.student.repository.SubjectScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Log4j2
@RequiredArgsConstructor
public class SubjectScheduleService {
    private final SubjectScheduleRepository subjectScheduleRepository;
    private final SubjectScheduleMapper subjectScheduleMapper;

    @Transactional
    public Set<SubjectScheduleDto> findAll() {
        try (Stream<SubjectSchedule> subjectScheduleStream = subjectScheduleRepository.findAllAsStream()) {
            return subjectScheduleStream.map(subjectScheduleMapper::toDto)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return new HashSet<>();
    }

    @Transactional
    public Set<SubjectScheduleDto> findAllBySchoolYearAndSectionAndSubject(Integer schoolYearId, Integer subjectId) {
        try(Stream<SubjectSchedule> subjectScheduleDtoStream =
                    subjectScheduleRepository.findAllBySubjectAndYear(schoolYearId, subjectId)) {
            return subjectScheduleDtoStream.map(subjectScheduleMapper::toDto)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return new HashSet<>();
    }

    @Transactional
    public Set<SubjectScheduleDto> findAllByYear(Integer schoolYearId) {
        try(Stream<SubjectSchedule> subjectScheduleStream =
                subjectScheduleRepository.findAllByYear(schoolYearId)) {
            return subjectScheduleStream.map(subjectScheduleMapper::toDto)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return new HashSet<>();
    }
}
