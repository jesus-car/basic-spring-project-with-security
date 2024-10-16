package com.newproject.basicprojectskeleton.presentation.dto.input;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientSaveRequest {
    private String name;
    private String email;
}
