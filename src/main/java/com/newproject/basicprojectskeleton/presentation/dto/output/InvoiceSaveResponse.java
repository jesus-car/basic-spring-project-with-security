package com.newproject.basicprojectskeleton.presentation.dto.output;

import com.newproject.basicprojectskeleton.persistence.entity.Client;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InvoiceSaveResponse {
    private String number;
    private String description;
    private Client client;
}