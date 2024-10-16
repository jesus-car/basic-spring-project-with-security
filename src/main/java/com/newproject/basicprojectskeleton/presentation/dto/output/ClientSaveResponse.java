package com.newproject.basicprojectskeleton.presentation.dto.output;

import com.newproject.basicprojectskeleton.persistence.entity.Invoice;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class ClientSaveResponse {
    private String name;
    private String email;
    private Set<Invoice> invoices;
}