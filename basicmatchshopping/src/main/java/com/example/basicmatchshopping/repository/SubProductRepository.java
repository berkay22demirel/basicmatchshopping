package com.example.basicmatchshopping.repository;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubProductRepository extends CrudRepository<Item, Long> {

}
