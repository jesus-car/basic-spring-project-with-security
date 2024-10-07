package com.newproject.basicprojectskeleton.presentation.dto.input;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSaveRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}