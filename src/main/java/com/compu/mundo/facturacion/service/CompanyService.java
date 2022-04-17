package com.compu.mundo.facturacion.service;


import com.compu.mundo.facturacion.entity.Client;
import com.compu.mundo.facturacion.entity.Company;

import java.util.List;

public interface CompanyService {

    public List<Company> getAll();

    public Company findById(Long id);

    public Company create(Company company);

    public Company update(Company company);

    public void delete(Long id);

}
