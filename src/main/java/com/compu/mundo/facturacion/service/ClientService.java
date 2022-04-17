package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Client;

import java.util.List;

public interface ClientService {

    public List<Client> allClients();

    public Client findById(Long id);

    public Client create(Client client);

    public Client update(Client client);

    public void deleteClient(Long id);
}
