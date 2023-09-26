package com.chavozo.webservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chavozo.webservice.domain.State;
import com.chavozo.webservice.repositories.StateRepository;
import com.chavozo.webservice.service.exceptions.ObjectNotFoundException;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    public State find(Integer id) {
        Optional<State> State = repository.findById(id);
        return State.orElseThrow(() -> new ObjectNotFoundException(
                "State not found! Id: " + id + ", Type: " + State.class.getSimpleName()));
    }

}
