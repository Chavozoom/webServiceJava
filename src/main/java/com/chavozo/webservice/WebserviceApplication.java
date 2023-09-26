package com.chavozo.webservice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chavozo.webservice.domain.Category;
import com.chavozo.webservice.repositories.CategoryRepository;

@SpringBootApplication
public class WebserviceApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String[] args) throws Exception {
		Category cat1 = new Category(null, "Office");
		Category cat2 = new Category(null, "House");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

}
