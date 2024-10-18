package com.newproject.basicprojectskeleton.presentation.dto.input;

import com.newproject.basicprojectskeleton.util.validation.IsValidUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSaveRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @IsValidUsername
    private String username;
    @Email
    private String email;
    @NotBlank
    private String password;
}