package com.newproject.basicprojectskeleton.util.mapper;

import com.newproject.basicprojectskeleton.persistence.entity.Invoice;
import com.newproject.basicprojectskeleton.presentation.dto.input.InvoiceSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.InvoiceSaveResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InvoiceMapper {
    Invoice toInvoiceEntity(InvoiceSaveRequest invoiceSaveRequest);

    InvoiceSaveResponse toInvoiceSaveResponse(Invoice invoice);
}
