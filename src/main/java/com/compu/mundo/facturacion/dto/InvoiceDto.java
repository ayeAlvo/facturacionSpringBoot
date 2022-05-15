package com.compu.mundo.facturacion.dto;

import com.compu.mundo.facturacion.entity.Client;
import com.compu.mundo.facturacion.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {
    private List<Product> product;
    private Client client;
}
