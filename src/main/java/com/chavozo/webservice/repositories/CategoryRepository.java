package com.chavozo.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chavozo.webservice.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
