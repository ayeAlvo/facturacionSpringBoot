package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Category;
import com.compu.mundo.facturacion.exception.CustomException;
import com.compu.mundo.facturacion.repository.CategoryRepository;
//import com.compu.mundo.facturacion.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

//    @Autowired
//    ProductRepository productRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new CustomException("No existe categoria con id " + id));
    }

    public Category update(Category category){
        Category categoryEdit = categoryRepository.findById(category.getId()).orElseThrow(() -> new CustomException("No existe categoria con id " + category.getId()));
        categoryEdit.setName(category.getName());
        return categoryRepository.save(categoryEdit);
    }

    public Category create(Category category){
        return categoryRepository.save(category);
    }

    public void delete(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CustomException("No existe categoria con id " + id));
        log.info("Se borro la categoria {}", category.getName());
        categoryRepository.deleteById(id);
    }

}
