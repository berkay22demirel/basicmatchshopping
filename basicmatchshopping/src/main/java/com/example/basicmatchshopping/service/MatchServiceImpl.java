package com.example.basicmatchshopping.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.basicmatchshopping.constant.Source;
import com.example.basicmatchshopping.entity.Product;
import com.example.basicmatchshopping.entity.SubProduct;

@Service
public class MatchServiceImpl implements MatchService {

	@Override
	public void addMatchedProduct(String subProductName, SubProduct subProduct, List<Product> products, Source source) {
		List<String> subProductNameList = Arrays.asList(subProductName.split(" "));

		if (!CollectionUtils.isEmpty(subProductNameList)) {
			subProductNameList = getAllStringToLowerCase(subProductNameList);

			for (Product product : products) {

				if (!isHaveSubProductForSource(product, source)) {
					List<String> productNameList = Arrays.asList(product.getName().split(" "));
					if (!CollectionUtils.isEmpty(productNameList)) {
						productNameList = getAllStringToLowerCase(productNameList);

						String subProductBrand = subProductNameList.get(0);
						String productBrand = productNameList.get(0);

						if (product.getCategory().getName().equals("Fresh Vegetables")
								|| product.getCategory().getName().equals("Fresh Fruits")) {

							int matchedCount = 0;
							for (String subProductString : subProductNameList) {

								if (productNameList.contains(subProductString)) {
									matchedCount++;
								}
							}

							if (matchedCount > 2) {
								subProduct.setProduct(product);
								product.getSubProducts().add(subProduct);
								break;
							}

						} else {

							if (subProductBrand.equals(productBrand)) {

								int matchedCount = 0;
								for (String subProductString : subProductNameList) {

									if (productNameList.contains(subProductString)) {
										matchedCount++;
									}
								}

								if (matchedCount > 2) {
									subProduct.setProduct(product);
									product.getSubProducts().add(subProduct);
									break;
								}
							}
						}

					} else {
						System.out.println("Problem2 : " + product.getName());
					}
				}
			}

		} else {
			System.out.println("Problem1 : " + subProductName);
		}
	}

	private List<String> getAllStringToLowerCase(List<String> list) {
		List<String> newList = new ArrayList<>();
		for (String string : list) {
			newList.add(string.toLowerCase());
		}
		return newList;
	}

	private boolean isHaveSubProductForSource(Product product, Source source) {
		for (SubProduct subProduct : product.getSubProducts()) {
			if (source.equals(subProduct.getSource())) {
				return true;
			}
		}
		return false;
	}

}
