package com.newproject.basicprojectskeleton.presentation.advice;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class CustomErrorResponse{
    private String message;
    private Map<String, String> errors;
}
