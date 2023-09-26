package com.chavozo.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chavozo.webservice.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
