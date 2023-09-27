package com.chavozo.webservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chavozo.webservice.domain.Client;
import com.chavozo.webservice.repositories.ClientRepository;
import com.chavozo.webservice.service.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client find(Integer id) {
        Optional<Client> client = repository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException(
                "Client not found! Id: " + id + ", Type: " + Client.class.getSimpleName()));
    }

}
