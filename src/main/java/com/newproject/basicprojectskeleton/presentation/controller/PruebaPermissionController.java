package com.newproject.basicprojectskeleton.presentation.controller;

import com.newproject.basicprojectskeleton.presentation.advice.SecurityErrorHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prueba-permission")
@HandleAuthorizationDenied(handlerClass = SecurityErrorHandler.class)
public class PruebaPermissionController {

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/get")
    public String get() {
        return "Hello World - GET";
    }
    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping("/post")
    public String post() {
        return "Hello World - POST";
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @PutMapping("/put")
    public String put() {
        return "Hello World - PUT";
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/delete")
    public String delete() {
        return "Hello World - DELETE";
    }

}
