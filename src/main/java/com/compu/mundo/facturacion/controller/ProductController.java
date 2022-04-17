package com.compu.mundo.facturacion.controller;

import com.compu.mundo.facturacion.entity.Product;
import com.compu.mundo.facturacion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/allProducts")
    public List<Product> getAllProducts(){
        return productService.getAll();
    }

    @GetMapping("getProduct/{id}")
    public Product getProduct(@PathVariable(value = "id") Long id){
        return productService.findById(id);
    }

    @PostMapping("/newProduct")
    public Product createProduct(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("/editProduct")
    public Product editProduct(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id){
        productService.delete(id);
    }

}
