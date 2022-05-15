package com.compu.mundo.facturacion.controller;

import com.compu.mundo.facturacion.dto.InvoiceDto;
import com.compu.mundo.facturacion.entity.Client;
import com.compu.mundo.facturacion.entity.Invoice;
import com.compu.mundo.facturacion.entity.Product;
import com.compu.mundo.facturacion.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/allInvoices")
    public List<Invoice> getAllInvoices(){
        return invoiceService.getAll();
    }

    @GetMapping("/getInvoice/{id}")
    public Invoice getInvoice(@PathVariable(value = "id") Long id){
        return invoiceService.findById(id);
    }

    @PostMapping("/newInvoice")
    public Invoice createInvoice(@RequestBody InvoiceDto newInvoice){
        return invoiceService.generate(newInvoice);
    }
}
