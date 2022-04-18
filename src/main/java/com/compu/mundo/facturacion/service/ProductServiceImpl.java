package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.dto.ProductDto;
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

    public List<Product> getAll(){
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

    public void delete(Long id){
        Product product = productRepository.findById(id).get();
        log.info("Se borro el producto {}", product.getName());
        productRepository.deleteById(id);
    }

    public ProductDto stock(Long id, int stock){
        Product product = productRepository.findById(id).get();

        if(product.getStock() == 0){
            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName());
            productDto.setStock(product.getStock());
            productDto.setMsg("No hay stock disponible");
            log.info("Se actualizo el estado a SIN STOCK");
            return productDto;
        }else if(product.getStock() < stock){
            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName());
            productDto.setStock(product.getStock());
            productDto.setMsg("No hay tanto stock, hay " + product.getStock() + " " + product.getName() + " disponibles");
            return productDto;
        }else{
            product.setStock(product.getStock() - stock);
            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName());
            productDto.setStock(product.getStock());
            productDto.setMsg("Se realizo la compra de " + product.getName());
            productRepository.save(product);
            log.info("Se puede realizar la compra, hay stock");
            return productDto;
        }

    }

//    public Product stock(Long id, int stock){
//        Product product = productRepository.findById(id).get();
//        if(stock <= 0){
//            product.setStock(0);
//            productRepository.save(product);
//            log.info("Se actualizo el estado a SIN STOCK");
//        }else{
//            product.setStock(stock);
//            productRepository.save(product);
//            log.info("Se actualizo el stock");
//        }
//        return product;
//    }

//    public Product buy(Long id){
//        Product product = productRepository.findById(id).get();
//        log.info(String.valueOf(product.getStock()));
//        int stock = product.getStock() -1;
//        log.info(String.valueOf(stock));
//        return product;
//    }

}
