package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Company;
import com.compu.mundo.facturacion.exception.CustomException;
import com.compu.mundo.facturacion.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAll(){
        log.info("|   Obteniendo lista de todas las empresas   |");
        try{
            return companyRepository.findAll();
        }catch (RuntimeException exception){
            throw new CustomException("Hubo un error en la base de datos, por favor intenta nuevamente en unos minutos");
        }

    }

    public Company findById(Long id){
        log.info("|   Buscando empresa por id {}   |", id);
        return companyRepository.findById(id).orElseThrow(() -> new CustomException("No existe empresa con id " + id));
    }

    public Company create(Company company){
        log.info("|   Creando nueva empresa '{}'   |", company.getName());
        return companyRepository.save(company);
    }

    public Company update(Company company){
        Company companyEdit = companyRepository.findById(company.getId()).orElseThrow(() -> new CustomException("No existe empresa con id " + company.getId()));
        companyEdit.setName(company.getName());
        companyEdit.setItem(company.getItem());
        log.warn("|   Editando empresa '{}' |", company.getName());
        return companyRepository.save(companyEdit);
    }

    public void delete(Long id){
        Company company = companyRepository.findById(id).orElseThrow(() -> new CustomException("No existe empresa con id " + id));
        log.info("|   Se borro la empresa '{}'   |", company.getName());
        companyRepository.deleteById(id);
    }

}
