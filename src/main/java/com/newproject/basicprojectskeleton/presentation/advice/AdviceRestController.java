package com.newproject.basicprojectskeleton.presentation.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceRestController {

//    @ExceptionHandler(AuthorizationDeniedException.class)
//    public String handleException(Exception e) {
//        return "No puedes pasar mongol";
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handleException(MethodArgumentNotValidException e) {
        // Crear un Map para los errores
        Map<String, String> errors = e.getBindingResult()
                .getFieldErrors()  // Obtiene solo los errores de los campos
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,   // Campo como clave
                        FieldError::getDefaultMessage  // Mensaje de error como valor
                ));

        // Crear el objeto de respuesta con el mensaje y el Map de errores
        CustomErrorResponse response = new CustomErrorResponse("Validation failed", errors);

        return ResponseEntity.badRequest().body(response);
    }
}
