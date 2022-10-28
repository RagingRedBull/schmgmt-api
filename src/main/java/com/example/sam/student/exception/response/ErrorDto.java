package com.example.sam.student.exception.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto {
    private final int httpStatus;
    private final String message;
    @JsonFormat(pattern="yyyy-MM-dd KK:mm:ss a")
    private final ZonedDateTime timeStamp;
    private String stackTrace;
    @JsonProperty(value = "validationErrors")
    private List<ValidationErrorDto> errors;

    public void addValidationError(String field, String message) {
        if (Objects.isNull(errors)) {
            errors = new ArrayList<>();
        }
        errors.add(new ValidationErrorDto(field, message));
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class ValidationErrorDto {
        private final String field;
        private final String message;
    }
}
