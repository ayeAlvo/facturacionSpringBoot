package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.dto.InvoiceDto;
import com.compu.mundo.facturacion.entity.Client;
import com.compu.mundo.facturacion.entity.Invoice;
import com.compu.mundo.facturacion.entity.Product;

import java.util.List;

public interface InvoiceService {

    public List<Invoice> getAll();

    public Invoice findById(Long id);

    public Invoice generate(InvoiceDto newInvoice);
}
