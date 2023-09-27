package com.chavozo.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chavozo.webservice.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
