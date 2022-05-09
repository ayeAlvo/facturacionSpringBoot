package com.compu.mundo.facturacion.service;
import com.compu.mundo.facturacion.entity.Category;
import com.compu.mundo.facturacion.entity.Product;

import java.util.List;

public interface CategoryService {
    public List<Category> getAll();

    public Category findById(Long id);

    public Category update(Category category);

    public Category create(Category category);

    public void delete(Long id);
}
