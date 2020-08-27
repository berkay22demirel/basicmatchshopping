package com.example.basicmatchshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
