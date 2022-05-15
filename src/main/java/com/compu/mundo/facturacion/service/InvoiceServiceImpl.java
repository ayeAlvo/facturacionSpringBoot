package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.dto.InvoiceDto;
import com.compu.mundo.facturacion.entity.Detail;
import com.compu.mundo.facturacion.entity.Invoice;
import com.compu.mundo.facturacion.entity.Product;
import com.compu.mundo.facturacion.exception.CustomException;
import com.compu.mundo.facturacion.repository.DetailRepository;
import com.compu.mundo.facturacion.repository.InvoiceRepository;
import com.compu.mundo.facturacion.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DetailRepository detailRepository;

    public List<Invoice> getAll(){
        log.info("|   Obteniendo lista de todas las facturas   |");
        return invoiceRepository.findAll();
    }

    public Invoice findById(Long id){
        log.info("|   Buscando factura por id {}   |", id);
        return invoiceRepository.findById(id).orElseThrow(() -> new CustomException("No existe factura con id " + id));
    }

    public Invoice generate(InvoiceDto newInvoice){

        log.info("entre a la funcion");
        System.out.println(newInvoice.toString());
        Invoice invoice = new Invoice();
        invoice.setClient(newInvoice.getClient());


        Detail detail = new Detail();
        detail.setQuantity(2);
        detail.setParcialPrice(0.0);
        detail.setProduct(newInvoice.getProduct());
        List<String> productsDetail = new ArrayList<>();
        for(Product product : newInvoice.getProduct()){
            log.info("entre al for");
            productsDetail.add(product.toString());
            System.out.println(productsDetail);

                detail.setProduct(newInvoice.getProduct());
                detail.setParcialPrice(detail.getParcialPrice() + product.getPrice());
//            Product productSum = productRepository.findById(product.getId()).orElseThrow(() -> new CustomException("No existe producto con id " + product.getId()));
        }

        invoiceRepository.save(invoice);
//        detailRepository.save(detail);
        return invoice;
    }

}
