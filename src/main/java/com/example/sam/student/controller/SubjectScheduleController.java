package com.example.sam.student.controller;

import com.example.sam.student.facade.SubjectScheduleFacade;
import com.example.sam.student.model.dto.SubjectScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/schedules")
@RequiredArgsConstructor
public class SubjectScheduleController {
    private final SubjectScheduleFacade subjectScheduleFacade;
    @GetMapping
    public Collection<SubjectScheduleDto> findAll() {
        return subjectScheduleFacade.findAll();
    }
    @GetMapping(path = "/{schoolYear}")
    public Collection<SubjectScheduleDto> findAllYearBySchoolYear(@PathVariable String schoolYear) {
        return subjectScheduleFacade.findAllByYear(schoolYear);
    }

    @GetMapping(path = "/{schoolYear}/subjects/{subjectId}")
    public Collection<SubjectScheduleDto> findAllBySchoolYearAndSubjectId(@PathVariable String schoolYear,
                                                                          @PathVariable Integer subjectId) {
        return subjectScheduleFacade.findAllByYearAndSubjectAndSection(schoolYear,subjectId);
    }
}
