package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.dto.ProductDto;
import com.compu.mundo.facturacion.entity.Product;
import com.compu.mundo.facturacion.exception.CustomException;
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
        log.info("|   Obteniendo lista de todos las productos   |");
        try{
            return productRepository.findAll();
        }catch (RuntimeException exception){
            throw new CustomException("Hubo un error en la base de datos, por favor intenta nuevamente en unos minutos");
        }
    }

    public Product findById(Long id){
        log.info("|   Buscando producto por id {}   |", id);
        return productRepository.findById(id).orElseThrow(() -> new CustomException("No existe producto con id " + id));
    }

    public Product create(Product product){
        log.info("|   Creando nuevo producto '{}'   |", product.getName());
        return productRepository.save(product);
    }

    public Product update(Product product){
        Product productEdit = productRepository.findById(product.getId()).orElseThrow(() -> new CustomException("No existe producto con id " + product.getId()));
        productEdit.setName(product.getName());
        productEdit.setStock(product.getStock());
        productEdit.setPrice(product.getPrice());
        productEdit.setDetail(product.getDetail());
        productEdit.setCategory(product.getCategory());
        log.warn("|   Editando producto '{}' |", product.getName());
        return productRepository.save(productEdit);
    }

    public void delete(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new CustomException("No existe producto con id " + id));
        log.info("|   Se borro el producto '{}'   |", product.getName());
        productRepository.deleteById(id);
    }

    public ProductDto stock(Long id, int stock){
        log.info("|   Verificando Stock   |");
        Product product = productRepository.findById(id).orElseThrow(() -> new CustomException("No existe producto con id " + id));;

        if(product.getStock() == 0){
            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName());
            productDto.setStock(product.getStock());
            productDto.setMsg("No hay stock disponible");
            log.info("|   Se actualizo el estado a SIN STOCK   |");
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
            log.info("|   Se realizo la compra con exito   |");
            return productDto;
        }

    }

}
