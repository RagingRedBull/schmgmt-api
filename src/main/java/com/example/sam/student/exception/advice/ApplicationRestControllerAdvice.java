package com.example.sam.student.exception.advice;

import com.example.sam.student.exception.InvalidSearchKeyException;
import com.example.sam.student.exception.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.Objects;

@RestControllerAdvice
public class ApplicationRestControllerAdvice {
    @ExceptionHandler(InvalidSearchKeyException.class)
    public ResponseEntity<ErrorDto> handleInvalidSearchKey(InvalidSearchKeyException exception) {
        return buildErrorDto(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentInvalid(MethodArgumentNotValidException exception) {
        ResponseEntity<ErrorDto> response = buildErrorDto(exception, HttpStatus.UNPROCESSABLE_ENTITY);
        ErrorDto dto = response.getBody();
        if (Objects.nonNull(dto)) {
            exception.getBindingResult().getFieldErrors().forEach(fieldError -> dto.addValidationError(
                    fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return response;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleAllUncaughtExceptions(Exception e) {
        return buildErrorDto("Something went wrong. hehe", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorDto> buildErrorDto(String message, HttpStatus httpStatus) {
        ErrorDto errorDto = ErrorDto.builder()
                .httpStatus(httpStatus.value())
                .timeStamp(ZonedDateTime.now())
                .message(message)
                .build();
        return ResponseEntity.status(httpStatus).body(errorDto);
    }

    private ResponseEntity<ErrorDto> buildErrorDto(Exception exception, HttpStatus httpStatus) {
        ErrorDto errorDto = ErrorDto.builder()
                .httpStatus(httpStatus.value())
                .timeStamp(ZonedDateTime.now())
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(httpStatus).body(errorDto);
    }
}
