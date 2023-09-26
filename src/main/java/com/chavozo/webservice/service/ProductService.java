/*
 * package com.chavozo.webservice.service;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Service;
 * 
 * import com.chavozo.webservice.domain.Product;
 * import com.chavozo.webservice.repositories.ProductRepository;
 * 
 * @Service
 * public class ProductService {
 * 
 * @Autowired
 * private ProductRepository repository;
 * 
 * public Product find(Integer id) {
 * Optional<Product> product = repository.findById(id);
 * return product.orElse(null);
 * }
 * 
 * }
 */