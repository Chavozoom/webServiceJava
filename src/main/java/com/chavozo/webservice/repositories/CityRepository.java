package com.chavozo.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chavozo.webservice.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
