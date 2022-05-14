package com.compu.mundo.facturacion.controller;

import com.compu.mundo.facturacion.entity.Detail;
import com.compu.mundo.facturacion.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DetailController {

    @Autowired
    DetailService detailService;

    @GetMapping("/allDetails")
    public List<Detail> getAllDetails(){
        return detailService.getAll();
    }

    @GetMapping("getDetail/{id}")
    public Detail getDetail(@PathVariable(value = "id") Long id){
        return detailService.findById(id);
    }
}
