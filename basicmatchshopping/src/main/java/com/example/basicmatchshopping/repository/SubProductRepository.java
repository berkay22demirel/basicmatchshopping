package com.example.basicmatchshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.SubProduct;

@Repository
public interface SubProductRepository extends CrudRepository<SubProduct, Integer> {

}
