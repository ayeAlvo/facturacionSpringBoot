package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Detail;
import com.compu.mundo.facturacion.exception.CustomException;
import com.compu.mundo.facturacion.repository.DetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DetailServiceImpl implements DetailService{

    @Autowired
    DetailRepository detailRepository;

    public List<Detail> getAll(){
        log.info("|   Obteniendo lista de todos los detalles   |");
        return detailRepository.findAll();
    }

    public Detail findById(Long id){
        log.info("|   Buscando producto por id {}   |", id);
        return detailRepository.findById(id).orElseThrow(() -> new CustomException("No existe detalle con id " + id));
    }
}
