package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Detail;

import java.util.List;

public interface DetailService {

    public List<Detail> getAll();

    public Detail findById(Long id);

//    public void parcialPrice(Long idProduct, Long idDetail);
}
