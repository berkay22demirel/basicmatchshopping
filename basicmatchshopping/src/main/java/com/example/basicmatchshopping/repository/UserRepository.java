package com.example.basicmatchshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.basicmatchshopping.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
