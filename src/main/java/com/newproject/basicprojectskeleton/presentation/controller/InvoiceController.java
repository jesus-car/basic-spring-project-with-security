package com.newproject.basicprojectskeleton.presentation.controller;

import com.newproject.basicprojectskeleton.presentation.dto.input.InvoiceSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.InvoiceSaveResponse;
import com.newproject.basicprojectskeleton.service.implementation.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/save")
    public InvoiceSaveResponse saveInvoice(@RequestBody InvoiceSaveRequest invoiceSaveRequest) {
        return invoiceService.saveInvoice(invoiceSaveRequest);
    }

}
