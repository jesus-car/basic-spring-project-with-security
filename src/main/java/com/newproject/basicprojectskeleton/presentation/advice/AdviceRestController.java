package com.newproject.basicprojectskeleton.presentation.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceRestController {

    @ExceptionHandler
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
