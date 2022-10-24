package com.example.sam.controller;

import com.example.sam.model.dto.SectionDto;
import com.example.sam.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/section")
@RequiredArgsConstructor
public class SectionController {
    private final SectionService sectionService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<SectionDto> findAll() {
        return sectionService.findAll();
    }

    @GetMapping(path = "/{id}")
    public SectionDto findById(@PathVariable Integer id) {
        return null;
    }
}
