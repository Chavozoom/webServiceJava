package com.chavozo.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chavozo.webservice.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
