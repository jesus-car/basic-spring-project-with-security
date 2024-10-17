package com.newproject.basicprojectskeleton.presentation.controller;

import com.newproject.basicprojectskeleton.presentation.dto.input.UserSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.UserSaveResponse;
import com.newproject.basicprojectskeleton.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final CompromisedPasswordChecker compromisedPasswordChecker;

    @PostMapping("/register")
    public UserSaveResponse saveUser(@RequestBody UserSaveRequest userSaveRequest) {
        CompromisedPasswordDecision decision = compromisedPasswordChecker.check(userSaveRequest.getPassword());

        if (decision.isCompromised()) {
            throw new IllegalArgumentException("Password is compromised");
        }
        return userService.saveUser(userSaveRequest);
    }

    @GetMapping("/{username}")
    public UserSaveResponse getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

}