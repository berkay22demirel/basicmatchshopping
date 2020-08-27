package com.example.basicmatchshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.ShoppingCartItem;

@Repository
public interface ShoppingCartItemRepository extends CrudRepository<ShoppingCartItem, Integer> {

}
