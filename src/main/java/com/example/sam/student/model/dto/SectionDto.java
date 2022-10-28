package com.example.sam.student.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Getter
@Setter
@Builder
@Jacksonized
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectionDto {
    private Integer id;
    private String name;
    @JsonProperty("students")
    private Set<StudentDto> studentDtos;
}
