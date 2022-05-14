package com.compu.mundo.facturacion.repository;

import com.compu.mundo.facturacion.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository <Invoice, Long> {
}
