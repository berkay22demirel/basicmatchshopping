package com.example.basicmatchshopping.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.name = :name")
	Collection<Product> findByName(@Param("name") String name);

	@Query(value = "SELECT * FROM product WHERE category_id = :category_id", nativeQuery = true)
	List<Product> findProductsByCategoryId(@Param("category_id") int categoryId);

}
