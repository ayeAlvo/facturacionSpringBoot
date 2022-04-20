package com.compu.mundo.facturacion.controller;

import com.compu.mundo.facturacion.dto.ProductDto;
import com.compu.mundo.facturacion.entity.Product;
import com.compu.mundo.facturacion.exception.CustomException;
import com.compu.mundo.facturacion.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
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
    public Product createProduct(@RequestBody @Valid Product product, BindingResult result){
        if(result.hasErrors()){
            String message = "";
            for (ObjectError error : result.getAllErrors()){
                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                message += String.format("%s: %s | ", field, error.getDefaultMessage());
            }
            throw new CustomException(message);
        }
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

    @PutMapping("sellProduct/{id}/{quanty}")
    public ProductDto seller(@PathVariable(value = "id") Long id, @PathVariable(value = "quanty") int quanty){
        return productService.stock(id, quanty);
    }

}
