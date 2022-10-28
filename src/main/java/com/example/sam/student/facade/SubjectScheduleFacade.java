package com.example.sam.student.facade;

import com.example.sam.student.model.dto.SchoolYearDto;
import com.example.sam.student.model.dto.SubjectScheduleDto;
import com.example.sam.student.service.SchoolYearService;
import com.example.sam.student.service.SectionService;
import com.example.sam.student.service.SubjectScheduleService;
import com.example.sam.student.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
@Log4j2
@RequiredArgsConstructor
public class SubjectScheduleFacade {
    private final SubjectScheduleService subjectScheduleService;
    private final SectionService sectionService;
    private final SubjectService subjectService;
    private final SchoolYearService schoolYearService;

    public Set<SubjectScheduleDto> findAllByYearAndSubjectAndSection(String schoolYear, Integer subjectId) {
        SchoolYearDto schoolYearEntity = schoolYearService.findByYear(schoolYear);
        return subjectScheduleService.findAllBySchoolYearAndSectionAndSubject(schoolYearEntity.getId(), subjectId);
    }

    public Collection<SubjectScheduleDto> findAll() {
        return subjectScheduleService.findAll();
    }

    public Collection<SubjectScheduleDto> findAllByYear(String schoolYear) {
        SchoolYearDto schoolYearDto = schoolYearService.findByYear(schoolYear);
        return subjectScheduleService.findAllByYear(schoolYearDto.getId());
    }
}
