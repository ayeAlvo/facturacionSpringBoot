package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Detail;
import com.compu.mundo.facturacion.entity.Invoice;
import com.compu.mundo.facturacion.entity.Product;
import com.compu.mundo.facturacion.exception.CustomException;
import com.compu.mundo.facturacion.repository.DetailRepository;
import com.compu.mundo.facturacion.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DetailServiceImpl implements DetailService{

    @Autowired
    DetailRepository detailRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Detail> getAll(){
        log.info("|   Obteniendo lista de todos los detalles   |");
        return detailRepository.findAll();
    }

    public Detail findById(Long id){
        log.info("|   Buscando detalle por id {}   |", id);
        return detailRepository.findById(id).orElseThrow(() -> new CustomException("No existe detalle con id " + id));
    }

//    public void parcialPrice(Double price){
//        log.info("entre al precio parcial");
//        Product product = productRepository.findById(idProduct).orElseThrow(() -> new CustomException("No existe producto con id " + idProduct));
//        Detail detail = detailRepository.findById(idDetail).orElseThrow(() -> new CustomException("No existe detalle con id " + idDetail));

//        detail.setParcialPrice(detail.getParcialPrice() + product.getPrice());
//        log.info(String.valueOf(detail.getParcialPrice()));
//
//    }
}
