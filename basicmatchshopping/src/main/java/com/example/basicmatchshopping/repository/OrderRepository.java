package com.example.basicmatchshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}
