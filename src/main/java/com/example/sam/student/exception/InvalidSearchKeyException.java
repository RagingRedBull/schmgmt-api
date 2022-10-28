package com.example.sam.student.exception;

public class InvalidSearchKeyException extends RuntimeException{
    public InvalidSearchKeyException(String message) {
        super(message);
    }
}
