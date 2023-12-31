package com.chavozo.webservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chavozo.webservice.domain.Category;
import com.chavozo.webservice.repositories.CategoryRepository;
import com.chavozo.webservice.service.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category find(Integer id) {
        Optional<Category> category = repository.findById(id);
        return category.orElseThrow(() -> new ObjectNotFoundException(
                "Category not found! Id: " + id + ", Type: " + Category.class.getSimpleName()));
    }

}
