package com.compu.mundo.facturacion.service;

import com.compu.mundo.facturacion.entity.Client;
import com.compu.mundo.facturacion.exception.CustomException;
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
        log.info("|   Obteniendo lista de todos los clientes   |");
        try{
            return clientRepository.findAll();
        }catch(RuntimeException exception){
            throw new CustomException("Hubo un error en la base de datos, por favor intenta nuevamente en unos minutos");
        }

    }

    public Client findById(Long id){
        log.info("|   Buscando Cliente por id {}   |", id);
        return clientRepository.findById(id).orElseThrow(() -> new CustomException("No existe cliente con id " + id));
    }

    public Client create(Client client){
        log.info("|   Creando nuevo cliente '{}'   |", client.getName());
        return clientRepository.save(client);
    }

    public Client update(Client client){
        Client clientEdit = clientRepository.findById(client.getId()).orElseThrow(() -> new CustomException("No existe cliente con id " + client.getId()));
        clientEdit.setName(client.getName());
        clientEdit.setLastName(client.getLastName());
        clientEdit.setEmail(client.getEmail());
        clientEdit.setPhone(client.getPhone());
        log.warn("|   Editando cliente '{}' |", client.getName());
        return clientRepository.save(clientEdit);
    }

    public void delete(Long id){
        Client client = clientRepository.findById(id).orElseThrow(() -> new CustomException("No existe cliente con id " + id));
        log.warn("|   Se borro el cliente '{}'   |", client.getName());
        clientRepository.deleteById(id);
    }

}
