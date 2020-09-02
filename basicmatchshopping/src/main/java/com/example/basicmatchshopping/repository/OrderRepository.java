package com.example.basicmatchshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

	@Query(value = "SELECT * FROM user_order WHERE user_id = :user_id", nativeQuery = true)
	List<Order> findOrdersByUserId(@Param("user_id") int userId);

}
