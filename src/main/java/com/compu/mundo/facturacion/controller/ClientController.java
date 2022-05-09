package com.compu.mundo.facturacion.controller;

import com.compu.mundo.facturacion.entity.Client;
import com.compu.mundo.facturacion.exception.CustomException;
import com.compu.mundo.facturacion.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/allClients")
    public List<Client> getAllClients(){
        return clientService.getAll();
    }

    @GetMapping("/getClient/{id}")
    public Client getClient(@PathVariable(value = "id") Long id){
        return clientService.findById(id);
    }

    @PostMapping("/newClient")
    public Client createClient(@RequestBody @Valid Client client, BindingResult result){
        if(result.hasErrors()){
            String message = "";
            for (ObjectError error : result.getAllErrors()){
                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                message += String.format("%s: %s | ", field, error.getDefaultMessage());
            }
            throw new CustomException(message);
        }
        return clientService.create(client);
    }

    @PutMapping("/editClient")
    public Client editClient(@RequestBody @Valid Client client, BindingResult result){
        if(result.hasErrors()){
            String message = "";
            for (ObjectError error : result.getAllErrors()){
                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                message += String.format("%s: %s | ", field, error.getDefaultMessage());
            }
            throw new CustomException(message);
        }
        return clientService.update(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable(value = "id") Long id){
        clientService.delete(id);
    }

}
