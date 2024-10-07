package com.newproject.basicprojectskeleton.presentation.dto.output;

import com.newproject.basicprojectskeleton.persistence.entity.Role;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Builder
public class UserSaveResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private LocalDateTime createdAt;
    private Set<Role> roles;
}