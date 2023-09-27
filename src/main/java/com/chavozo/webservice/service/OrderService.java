package com.chavozo.webservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chavozo.webservice.domain.Order;
import com.chavozo.webservice.repositories.OrderRepository;
import com.chavozo.webservice.service.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order find(Integer id) {
        Optional<Order> order = repository.findById(id);
        return order.orElseThrow(() -> new ObjectNotFoundException(
                "Order not found! Id: " + id + ", Type: " + Order.class.getSimpleName()));
    }
}
