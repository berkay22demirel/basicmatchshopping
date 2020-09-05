package com.example.basicmatchshopping.constant;

public enum MorrisonsLink {

	MEAT_FISH("Meat Fish", "https://groceries.morrisons.com/browse/meat-fish-179549?display=500"),
	FRUIT_VEG("FRUIT VEG", "https://groceries.morrisons.com/browse/fruit-veg-176738?display=500"),
	FRESH("FRESH", "https://groceries.morrisons.com/browse/fresh-176739?display=500"),
	BAKERY("BAKERY", "https://groceries.morrisons.com/browse/bakery-cakes-102210?display=500"),
	FOOD_CUPBOARD("FOOD CUPBOARD", "https://groceries.morrisons.com/browse/food-cupboard-102705?display=500"),
	FROZEN("FROZEN", "https://groceries.morrisons.com/browse/frozen-180331?display=500"),
	DRINK("DRINK", "https://groceries.morrisons.com/browse/drinks-103644?display=500");

	private String categoryName;
	private String categoryLink;

	private MorrisonsLink(String categoryName, String categoryLink) {
		this.categoryName = categoryName;
		this.categoryLink = categoryLink;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryLink() {
		return categoryLink;
	}

	public void setCategoryLink(String categoryLink) {
		this.categoryLink = categoryLink;
	}

}
