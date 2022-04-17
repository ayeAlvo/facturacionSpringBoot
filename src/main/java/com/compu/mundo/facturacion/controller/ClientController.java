package com.compu.mundo.facturacion.controller;

import com.compu.mundo.facturacion.entity.Client;
import com.compu.mundo.facturacion.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/allClients")
    public List<Client> getAllClients(){
        return clientService.allClients();
    }

    @GetMapping("/getClient/{id}")
    public Client getClient(@PathVariable(value = "id") Long id){
        return clientService.findById(id);
    }

    @PostMapping("/newClient")
    public Client createClient(@RequestBody Client client){
        return clientService.create(client);
    }

    @PutMapping("/editClient")
    public Client editClient(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable(value = "id") Long id){
        clientService.deleteClient(id);
    }

}
