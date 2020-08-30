package com.example.basicmatchshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.SubProduct;

@Repository
public interface SubProductRepository extends CrudRepository<SubProduct, Integer> {

	@Query(value = "SELECT * FROM sub_product WHERE product_id = :product_id", nativeQuery = true)
	List<SubProduct> findByProductId(@Param("product_id") int productId);

}
