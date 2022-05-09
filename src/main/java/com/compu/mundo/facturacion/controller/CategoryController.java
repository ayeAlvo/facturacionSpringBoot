package com.compu.mundo.facturacion.controller;

import com.compu.mundo.facturacion.entity.Category;
import com.compu.mundo.facturacion.exception.CustomException;
import com.compu.mundo.facturacion.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/allCategories")
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/getCategory/{id}")
    public Category getCategory(@PathVariable(value = "id") Long id){
        return categoryService.findById(id);
    }

    @PutMapping("/editCategory")
    public Category editCategory(@RequestBody  @Valid Category category, BindingResult result){
        if(result.hasErrors()){
            String message = "";
            for (ObjectError error : result.getAllErrors()){
                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                message += String.format("%s: %s | ", field, error.getDefaultMessage());
            }
            throw new CustomException(message);
        }
        return categoryService.update(category);
    }

    @PostMapping("/newCategory")
    public Category createCategory(@RequestBody @Valid Category category, BindingResult result){
        if(result.hasErrors()){
            String message = "";
            for (ObjectError error : result.getAllErrors()){
                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                message += String.format("%s: %s | ", field, error.getDefaultMessage());
            }
            throw new CustomException(message);
        }
        return categoryService.create(category);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public void deleteCategory(@PathVariable(value = "id") Long id){
        categoryService.delete(id);
    }
}
