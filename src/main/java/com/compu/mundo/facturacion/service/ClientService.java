package com.compu.mundo.facturacion.service;
import com.compu.mundo.facturacion.entity.Client;
import java.util.List;

public interface ClientService {

    public List<Client> getAll();

    public Client findById(Long id);

    public Client create(Client client);

    public Client update(Client client);

    public void delete(Long id);
}
