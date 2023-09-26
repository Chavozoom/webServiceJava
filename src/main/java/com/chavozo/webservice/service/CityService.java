package com.chavozo.webservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chavozo.webservice.domain.City;
import com.chavozo.webservice.repositories.CityRepository;
import com.chavozo.webservice.service.exceptions.ObjectNotFoundException;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public City find(Integer id) {
        Optional<City> City = repository.findById(id);
        return City.orElseThrow(() -> new ObjectNotFoundException(
                "City not found! Id: " + id + ", Type: " + City.class.getSimpleName()));
    }
}
