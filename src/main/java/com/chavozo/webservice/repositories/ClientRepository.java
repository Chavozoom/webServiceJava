package com.chavozo.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chavozo.webservice.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
