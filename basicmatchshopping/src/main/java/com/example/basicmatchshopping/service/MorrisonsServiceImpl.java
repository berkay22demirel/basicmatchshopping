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

import com.example.basicmatchshopping.constant.AmountType;
import com.example.basicmatchshopping.constant.MorrisonsLink;
import com.example.basicmatchshopping.constant.Source;
import com.example.basicmatchshopping.entity.Product;
import com.example.basicmatchshopping.entity.SubProduct;
import com.example.basicmatchshopping.util.WebCrawlerUtil;

import javassist.NotFoundException;

@Service
public class MorrisonsServiceImpl implements MorrisonsService {

	@Autowired
	private ProductService productService;
	@Autowired
	private SubProductService subProductService;
	@Autowired
	private MatchService matchService;

	@Override
	public void fillProduct() throws InterruptedException, NotFoundException {
		subProductService.deleteAllBySource("MORRISONS");
		List<Product> products = productService.findAll();
		List<MorrisonsLink> morrisonsLinks = Arrays.asList(MorrisonsLink.values());
		for (MorrisonsLink morrisonsLink : morrisonsLinks) {
			System.out.println("____________________________" + morrisonsLink.getCategoryName()
					+ "____________________________________________________________________________________");
			System.out.println("");
			List<SubProduct> subProducts = getSubProducts(morrisonsLink.getCategoryLink(), products, Source.MORRISONS);
			for (SubProduct subProduct : subProducts) {
				if (subProduct.getProduct() != null) {
					subProductService.create(subProduct);
				}
			}
		}
	}

	private List<SubProduct> getSubProducts(String url, List<Product> products, Source source)
			throws InterruptedException {
		Document doc = Jsoup.parse(WebCrawlerUtil.getContentMarrisons(url));
		return getSubProducts(doc, products, source);
	}

	private List<SubProduct> getSubProducts(Document doc, List<Product> products, Source source)
			throws InterruptedException {
		List<SubProduct> subProducts = new ArrayList<>();
		Elements subCategoryElements = doc.getElementsByClass("fops-item fops-item--on_offer");
		subCategoryElements.addAll(doc.getElementsByClass("fops-item fops-item--new"));
		subCategoryElements.addAll(doc.getElementsByClass("fops-item fops-item--other"));
		for (Element subCategory : subCategoryElements) {
			String name = subCategory.getElementsByClass("fop-title").attr("title");
			String amountString = subCategory.getElementsByClass("fop-unit-price").html();
			String link = "https://groceries.morrisons.com" + subCategory.getElementsByTag("a").attr("href");

			SubProduct subProduct = new SubProduct();
			subProduct.setSource(Source.MORRISONS);
			subProduct.setSourceLink(link);

			try {
				fillAmountInfo(subProduct, amountString);
				subProducts.add(subProduct);
				matchService.addMatchedProduct(name, subProduct, products, source);
			} catch (Exception e) {
				System.out.println("Problem Exception Amount String : " + amountString);
				System.out.println("Berkay Excepption " + e.getLocalizedMessage() + " - " + e.getMessage());
			}
		}
		return subProducts;
	}

	private void fillAmountInfo(SubProduct subProduct, String amountString) throws Exception {

		String[] amountStringArray = amountString.split(" ");
		String price = amountStringArray[0];
		String amount;
		if (amountStringArray.length == 2) {
			amount = amountStringArray[1];
		} else {
			amount = amountStringArray[2];
		}

		if (price.charAt(0) == '£') {
			price = price.substring(1, price.length());
		} else {
			price = price.replace(".", "0");
			price = price.replace("p", "0");
			price = price.substring(0, 2);
			price = "0." + price;
		}
		subProduct.setPrice(Double.valueOf(price));

		if (amount.equals("kg")) {
			subProduct.setAmount(1);
			subProduct.setAmountType(AmountType.KILO);
		} else if (amount.equals("100g")) {
			subProduct.setAmount(0.1);
			subProduct.setAmountType(AmountType.KILO);
		} else if (amount.equals("500g")) {
			subProduct.setAmount(0.5);
			subProduct.setAmountType(AmountType.KILO);
		} else if (amount.equals("10g")) {
			subProduct.setAmount(0.01);
			subProduct.setAmountType(AmountType.KILO);
		} else if (amount.equals("100ml")) {
			subProduct.setAmount(0.1);
			subProduct.setAmountType(AmountType.LITRE);
		} else if (amount.equals("500ml")) {
			subProduct.setAmount(0.5);
			subProduct.setAmountType(AmountType.LITRE);
		} else if (amount.equals("1ml")) {
			subProduct.setAmount(0.001);
			subProduct.setAmountType(AmountType.LITRE);
		} else if (amount.equals("10ml")) {
			subProduct.setAmount(0.01);
			subProduct.setAmountType(AmountType.LITRE);
		} else if (amount.equals("litre")) {
			subProduct.setAmount(1);
			subProduct.setAmountType(AmountType.LITRE);
		} else if (amount.equals("each")) {
			subProduct.setAmount(1);
			subProduct.setAmountType(AmountType.EACH);
		} else {
			throw new Exception("amount type bulunamadı!");
		}
	}

}
