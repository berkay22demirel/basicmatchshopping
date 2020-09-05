package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.constant.Source;
import com.example.basicmatchshopping.entity.Product;
import com.example.basicmatchshopping.entity.SubProduct;

public interface MatchService {

	public void addMatchedProduct(String subProductName, SubProduct subProduct, List<Product> products, Source source);

}
