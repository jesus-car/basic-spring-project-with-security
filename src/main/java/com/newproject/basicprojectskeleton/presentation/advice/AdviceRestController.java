package com.newproject.basicprojectskeleton.presentation.advice;

import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceRestController {

//    @ExceptionHandler(AuthorizationDeniedException.class)
//    public String handleException(Exception e) {
//        return "No puedes pasar mongol";
//    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException(Exception e) {
        return "No puedes pasar" + e.getMessage();
    }
}
