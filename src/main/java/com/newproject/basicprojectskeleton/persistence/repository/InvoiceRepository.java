package com.newproject.basicprojectskeleton.persistence.repository;

import com.newproject.basicprojectskeleton.persistence.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
