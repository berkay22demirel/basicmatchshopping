package com.example.basicmatchshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {

	@Query(value = "SELECT * FROM shopping_cart WHERE user_id = :user_id and is_active = 1", nativeQuery = true)
	List<ShoppingCart> findActiveShoppingCartByUserId(@Param("user_id") int userId);

}
