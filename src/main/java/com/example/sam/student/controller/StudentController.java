package com.example.sam.student.controller;

import com.example.sam.student.model.dto.StudentDto;
import com.example.sam.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
@Log4j2
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping(path = "/{id}")
    public StudentDto getStudentById(@PathVariable Integer id) {
        return studentService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentDto createNewStudent(@RequestBody StudentDto studentDto) {
        log.info("New Student: " + studentDto);
        return studentService.saveOne(studentDto);
    }
}
