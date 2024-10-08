package com.newproject.basicprojectskeleton.presentation.controller;

import com.newproject.basicprojectskeleton.presentation.dto.input.UserSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.UserSaveResponse;
import com.newproject.basicprojectskeleton.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public UserSaveResponse saveUser(@RequestBody UserSaveRequest userSaveRequest) {
        return userService.saveUser(userSaveRequest);
    }

    @GetMapping("/{username}")
    public UserSaveResponse getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

}