package com.example.basicmatchshopping.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.basicmatchshopping.constant.AmazonLink;
import com.example.basicmatchshopping.constant.AmountType;
import com.example.basicmatchshopping.constant.Source;
import com.example.basicmatchshopping.entity.Category;
import com.example.basicmatchshopping.entity.Product;
import com.example.basicmatchshopping.entity.SubProduct;
import com.example.basicmatchshopping.util.WebCrawlerUtil;

import javassist.NotFoundException;

@Service
public class AmazonServiceImpl implements AmazonService {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SubProductService subProductService;

	@Override
	public void fillProduct() throws InterruptedException, NotFoundException {
		List<AmazonLink> amazonLinks = Arrays.asList(AmazonLink.values());
		for (AmazonLink amazonLink : amazonLinks) {
			System.out.println("____________________________" + amazonLink.getCategoryName()
					+ "____________________________________________________________________________________");
			System.out.println("");
			Category category = categoryService.findByName(amazonLink.getCategoryName());
			List<SubProduct> subProducts = getSubProducts(amazonLink.getCategoryLink(), category);
			for (SubProduct subProduct : subProducts) {
				try {
					Product existedProduct = productService.findByName(subProduct.getProduct().getName());
					SubProduct existedSubProduct = subProductService.findByProductId(existedProduct.getId());
					subProduct.getProduct().setId(existedProduct.getId());
					subProduct.setId(existedSubProduct.getId());
					productService.update(subProduct.getProduct());
					subProductService.update(subProduct);
				} catch (NotFoundException e) {
					productService.create(subProduct.getProduct());
					subProductService.create(subProduct);
				}
			}
		}
	}

	private List<SubProduct> getSubProducts(String url, Category category) throws InterruptedException {
		Document doc = Jsoup.parse(WebCrawlerUtil.getContent(url));
		return getSubProducts(doc, category);
	}

	private List<SubProduct> getSubProducts(Document doc, Category category) throws InterruptedException {
		List<SubProduct> subProducts = new ArrayList<>();
		Elements subCategoryElements = doc.getElementsByClass("a-row a-spacing-none kepler-carousel-title");
		for (Element subCategory : subCategoryElements) {
			String subCategoryLink = "https://www.amazon.co.uk/" + subCategory.getElementsByTag("a").attr("href");
			Document subCategoryDoc = Jsoup.parse(WebCrawlerUtil.getContent(subCategoryLink));
			Elements productElements = subCategoryDoc.getElementsByClass("a-section a-spacing-medium");
			if (!CollectionUtils.isEmpty(productElements)) {
				subProducts.addAll(getSubProducts(productElements, category));
			} else {
				subProducts.addAll(getSubProducts(subCategoryDoc, category));
			}
		}
		return subProducts;
	}

	private List<SubProduct> getSubProducts(Elements productElements, Category category) {
		List<SubProduct> subProducts = new ArrayList<>();
		for (Element productElement : productElements) {
			String productName = productElement.getElementsByClass("a-size-base-plus a-color-base a-text-normal")
					.html();
			String priceAndAmountString = productElement.getElementsByClass("a-size-base a-color-secondary").html();
			if (!StringUtils.isEmpty(productName) && !StringUtils.isEmpty(priceAndAmountString)) {

				System.out.print(productName + " --- " + priceAndAmountString);

				String imageString = productElement.getElementsByTag("img").attr("src");
				String sourceLinkString = "https://www.amazon.co.uk/"
						+ productElement.getElementsByTag("a").attr("href");
				String[] pricateAndAmountStringArray = priceAndAmountString.split("/");
				String priceString = pricateAndAmountStringArray[0].replace("(", "").replace("£", "");
				String amountString = pricateAndAmountStringArray[1].replace(")", "");

				System.out.print(
						" --- " + amountString + "---" + imageString + "---" + sourceLinkString + "---" + priceString);

				Product product = new Product();
				product.setName(productName.split(",")[0]);
				product.setImagePath(imageString);
				product.setCategory(category);
				SubProduct subProduct = new SubProduct();
				subProduct.setPrice(Double.valueOf(priceString));
				fillAmountInfo(subProduct, amountString);
				subProduct.setProduct(product);
				subProduct.setSource(Source.AMAZON);
				subProduct.setSourceLink(sourceLinkString);

				if (subProduct.getAmountType() == null) {
					break;
				}
				subProducts.add(subProduct);

				System.out.print("\n");
			}
		}
		return subProducts;
	}

	private void fillAmountInfo(SubProduct subProduct, String amountString) {
		if (amountString.equals("each")) {
			subProduct.setAmount(1);
			subProduct.setAmountType(AmountType.EACH);
		} else if (amountString.equals("Item")) {
			subProduct.setAmount(1);
			subProduct.setAmountType(AmountType.ITEM);
		} else if (amountString.equals("kg")) {
			subProduct.setAmount(1);
			subProduct.setAmountType(AmountType.KILO);
		} else if (amountString.equals("100 g")) {
			subProduct.setAmount(0.1);
			subProduct.setAmountType(AmountType.KILO);
		} else if (amountString.equals("100 ml")) {
			subProduct.setAmount(0.1);
			subProduct.setAmountType(AmountType.LITRE);
		} else if (amountString.equals("l")) {
			subProduct.setAmount(1);
			subProduct.setAmountType(AmountType.LITRE);
		} else if (amountString.equals("Count")) {
			subProduct.setAmount(1);
			subProduct.setAmountType(AmountType.COUNT);
		} else if (amountString.equals("Pack")) {
			subProduct.setAmount(1);
			subProduct.setAmountType(AmountType.PACK);
		} else {
			System.out.println("fillAmountInfo - PROBLEM - " + amountString);
		}
	}

}
