package com.compu.mundo.facturacion.controller;

import com.compu.mundo.facturacion.entity.Company;
import com.compu.mundo.facturacion.exception.CustomException;
import com.compu.mundo.facturacion.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/allCompanies")
    public List<Company> getAllCompanies(){
        return companyService.getAll();
    }

    @GetMapping("/getCompany/{id}")
    public Company getCompany(@PathVariable(value = "id") Long id){
        return companyService.findById(id);
    }

    @PostMapping("/newCompany")
    public Company createCompany(@RequestBody @Valid Company company, BindingResult result){
        if(result.hasErrors()){
            String message = "";
            for (ObjectError error : result.getAllErrors()){
                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                message += String.format("%s: %s | ", field, error.getDefaultMessage());
            }
            throw new CustomException(message);
        }
        return companyService.create(company);
    }

    @PutMapping("/editCompany")
    public Company editCompany(@RequestBody Company company){
        return companyService.update(company);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public void deleteCompany(@PathVariable(value = "id") Long id){
        companyService.delete(id);
    }
}
