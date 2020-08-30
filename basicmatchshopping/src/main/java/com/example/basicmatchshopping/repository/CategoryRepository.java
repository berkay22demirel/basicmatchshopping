package com.example.basicmatchshopping.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

	@Query("SELECT c FROM Category c WHERE c.name = :name")
	Collection<Category> findByName(@Param("name") String name);

}
