package com.example.sam.student.controller;

import com.example.sam.student.model.dto.SectionDto;
import com.example.sam.student.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/sections")
@RequiredArgsConstructor
public class SectionController {
    private final SectionService sectionService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<SectionDto> findAll() {
        return sectionService.findAll();
    }
    @GetMapping(params = {"schoolYearId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<SectionDto> findAllBySchoolYearId(@RequestParam Integer schoolYearId) {
        return sectionService.findAllBySchoolYearId(schoolYearId);
    }
    @GetMapping(path = "/{id}")
    public SectionDto findById(@PathVariable Integer id) {
        return sectionService.findById(id);
    }
}
