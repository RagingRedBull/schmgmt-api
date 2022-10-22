package com.example.sam.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Getter
@Builder
@Jacksonized
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {
    private Integer id;
    private String internalId;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
