package com.compu.mundo.facturacion.controller;

import com.compu.mundo.facturacion.entity.Company;
import com.compu.mundo.facturacion.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/allCompanies")
    public List<Company> getAllCompanies(){
        return companyService.allCompanies();
    }

    @GetMapping("/getCompany/{id}")
    public Company getCompany(@PathVariable(value = "id") Long id){
        return companyService.findById(id);
    }

    @PostMapping("/newCompany")
    public Company createCompany(@RequestBody Company company){
        return companyService.create(company);
    }

    @PutMapping("/editCompany")
    public Company editCompany(@RequestBody Company company){
        return companyService.update(company);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public void deleteCompany(@PathVariable(value = "id") Long id){
        companyService.deleteCompany(id);
    }
}
