package com.newproject.basicprojectskeleton.service.implementation;

import com.newproject.basicprojectskeleton.persistence.entity.Client;
import com.newproject.basicprojectskeleton.persistence.entity.Invoice;
import com.newproject.basicprojectskeleton.persistence.repository.InvoiceRepository;
import com.newproject.basicprojectskeleton.presentation.dto.input.InvoiceSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.InvoiceSaveResponse;
import com.newproject.basicprojectskeleton.util.mapper.InvoiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ClientService clientService;
    private final InvoiceMapper invoiceMapper;

    @Transactional
    public InvoiceSaveResponse saveInvoice(InvoiceSaveRequest invoiceSaveRequest) {
        Client client = clientService.findByName(invoiceSaveRequest.getClient().getName());

        Invoice invoice = new Invoice();
        invoice.setClient(client);
        invoice.setDescription(invoiceSaveRequest.getDescription());
        invoice.setNumber(invoiceSaveRequest.getNumber());


        client.getInvoices().add(invoice);

        return invoiceMapper.toInvoiceSaveResponse(invoiceRepository.save(invoice));
    }
}
