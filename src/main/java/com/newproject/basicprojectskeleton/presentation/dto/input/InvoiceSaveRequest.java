package com.newproject.basicprojectskeleton.presentation.dto.input;

import com.newproject.basicprojectskeleton.persistence.entity.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InvoiceSaveRequest {
    private String number;
    private String description;
    private Client client;
}
