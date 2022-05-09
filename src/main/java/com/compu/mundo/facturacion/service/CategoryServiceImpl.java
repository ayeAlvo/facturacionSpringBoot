package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Category;
import com.compu.mundo.facturacion.exception.CustomException;
import com.compu.mundo.facturacion.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;


    public List<Category> getAll(){
        log.info("|   Obteniendo lista de todas las categorias   |");
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        log.info("|   Buscando categoria por id {}   |", id);
        return categoryRepository.findById(id).orElseThrow(() -> new CustomException("No existe categoria con id " + id));
    }

    public Category update(Category category){
        Category categoryEdit = categoryRepository.findById(category.getId()).orElseThrow(() -> new CustomException("No existe categoria con id " + category.getId()));
        categoryEdit.setName(category.getName());
        log.warn("|   Editando categoria '{}' |", category.getName());
        return categoryRepository.save(categoryEdit);
    }

    public Category create(Category category){
        log.info("|   Creando nueva categoria de '{}'   |", category.getName());
        return categoryRepository.save(category);
    }

    public void delete(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CustomException("No existe categoria con id " + id));
        log.warn("|   Se borro la categoria '{}'   |", category.getName());
        categoryRepository.deleteById(id);
    }



}
