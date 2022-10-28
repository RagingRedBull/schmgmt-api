package com.example.sam.student.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectDto {
    private int id;
    private String name;
    private String code;
}
