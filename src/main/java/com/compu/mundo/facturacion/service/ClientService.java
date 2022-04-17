package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Client;

import java.util.List;

public interface ClientService {

    public List<Client> allClients();

    public Client findById(Long id);
}
