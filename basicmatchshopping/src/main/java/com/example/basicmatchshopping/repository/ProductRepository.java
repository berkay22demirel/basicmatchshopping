package com.example.basicmatchshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
