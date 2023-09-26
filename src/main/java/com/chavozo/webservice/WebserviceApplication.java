package com.chavozo.webservice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chavozo.webservice.domain.Category;
import com.chavozo.webservice.domain.Product;
import com.chavozo.webservice.repositories.CategoryRepository;
import com.chavozo.webservice.repositories.ProductRepository;

@SpringBootApplication
public class WebserviceApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String[] args) throws Exception {
		Category cat1 = new Category(null, "Office");
		Category cat2 = new Category(null, "House");

		Product prod1 = new Product(null, "Laptop", 2100.00);
		Product prod2 = new Product(null, "Chair", 210.00);
		Product prod3 = new Product(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2));

		prod1.getCategories().addAll(Arrays.asList(cat1, cat2));
		prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategories().addAll(Arrays.asList(cat2));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
	}

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

}
