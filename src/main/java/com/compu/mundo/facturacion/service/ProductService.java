package com.compu.mundo.facturacion.service;
import com.compu.mundo.facturacion.dto.ProductDto;
import com.compu.mundo.facturacion.entity.Product;
import java.util.List;

public interface ProductService {

    public List<Product> getAll();

    public Product findById(Long id);

    public Product create(Product product);

    public Product update(Product product);

    public void delete(Long id);

    public ProductDto stock(Long id, int stock);

}
