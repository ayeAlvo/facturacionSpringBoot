package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> allProducts();

    public Product findById(Long id);

    public Product create(Product product);

    public Product update(Product product);

    public void deleteProduct(Long id);
}
