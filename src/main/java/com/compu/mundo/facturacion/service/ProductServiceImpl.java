package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Client;
import com.compu.mundo.facturacion.entity.Product;
import com.compu.mundo.facturacion.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    public List<Product> allProducts(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public Product update(Product product){
        Product productEdit = productRepository.findById(product.getId()).get();
        productEdit.setName(product.getName());
        productEdit.setStock(product.getStock());
        productEdit.setPrice(product.getPrice());
        productEdit.setDetail(product.getDetail());
        productEdit.setCategory(product.getCategory());
        return productRepository.save(productEdit);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).get();
        log.info("Se borro el producto {}", product.getName());
        productRepository.deleteById(id);
    }

}
