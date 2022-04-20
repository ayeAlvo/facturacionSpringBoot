package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Client;
import com.compu.mundo.facturacion.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Client findById(Long id){
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Client create(Client client){
        return clientRepository.save(client);
    }

    public Client update(Client client){
        Client clientEdit = clientRepository.findById(client.getId()).get();
        clientEdit.setName(client.getName());
        clientEdit.setLastName(client.getLastName());
        clientEdit.setEmail(client.getEmail());
        clientEdit.setPhone(client.getPhone());
        return clientRepository.save(clientEdit);
    }

    public void delete(Long id){
        Client client = clientRepository.findById(id).get();
        log.info("Se borro el cliente {}", client.getName());
        clientRepository.deleteById(id);
    }

}
