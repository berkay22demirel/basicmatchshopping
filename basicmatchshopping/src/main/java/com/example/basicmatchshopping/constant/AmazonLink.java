package com.example.basicmatchshopping.constant;

public enum AmazonLink {

	FRESH_VEGETABLES("Fresh Vegetables",
			"https://www.amazon.co.uk/fmc/category/ref=cg_banyantc_1a1_w?almBrandId=QW1hem9uIEZyZXNo&node=6860088031&pf_rd_m=A3P5ROKL5A1OLE&pf_rd_s=alm-storefront-desktop-bottom-4&pf_rd_r=11C3HAPKG6EQ3ACVY94R&pf_rd_t=0&pf_rd_p=64501cab-612b-4577-b46e-8186c9dd6191&pf_rd_i=FMCDummyValue"),
	FRESH_FRUITS("Fresh Fruits",
			"https://www.amazon.co.uk/alm/category/ref=cg_banyantc_1b1_w?almBrandId=QW1hem9uIEZyZXNo&node=6860087031&ref_=fs_dsk_cp_ai_sml_1_6860086031&pf_rd_m=A3P5ROKL5A1OLE&pf_rd_s=alm-storefront-desktop-bottom-4&pf_rd_r=11C3HAPKG6EQ3ACVY94R&pf_rd_t=0&pf_rd_p=64501cab-612b-4577-b46e-8186c9dd6191&pf_rd_i=FMCDummyValue"),
	MEAT_SEAFOOD("Meat & seafood",
			"https://www.amazon.co.uk/fmc/m/20200049/ref=cg_banyantc_1c1_w?almBrandId=QW1hem9uIEZyZXNo&pf_rd_m=A3P5ROKL5A1OLE&pf_rd_s=alm-storefront-desktop-bottom-4&pf_rd_r=11C3HAPKG6EQ3ACVY94R&pf_rd_t=0&pf_rd_p=64501cab-612b-4577-b46e-8186c9dd6191&pf_rd_i=FMCDummyValue"),
	DAIRY_CHEESE_EGGS("Dairy, Cheese & Eggs",
			"https://www.amazon.co.uk/fmc/category/ref=cg_banyantc_1d1_w?almBrandId=QW1hem9uIEZyZXNo&node=358588031&pf_rd_m=A3P5ROKL5A1OLE&pf_rd_s=alm-storefront-desktop-bottom-4&pf_rd_r=11C3HAPKG6EQ3ACVY94R&pf_rd_t=0&pf_rd_p=64501cab-612b-4577-b46e-8186c9dd6191&pf_rd_i=FMCDummyValue"),
	BAKERY("Bakery",
			"https://www.amazon.co.uk/fmc/category/ref=cg_banyantc_1e1_w?almBrandId=QW1hem9uIEZyZXNo&node=358582031&pf_rd_m=A3P5ROKL5A1OLE&pf_rd_s=alm-storefront-desktop-bottom-4&pf_rd_r=11C3HAPKG6EQ3ACVY94R&pf_rd_t=0&pf_rd_p=64501cab-612b-4577-b46e-8186c9dd6191&pf_rd_i=FMCDummyValue"),
	CEREALS_BREAKFAST_BARS("Cereals & Breakfast Bars",
			"https://www.amazon.co.uk/fmc/category/ref=cg_banyantc_1f1_w?almBrandId=QW1hem9uIEZyZXNo&node=358595031&pf_rd_m=A3P5ROKL5A1OLE&pf_rd_s=alm-storefront-desktop-bottom-4&pf_rd_r=G5YD2JG8QM3HH785Y848&pf_rd_t=0&pf_rd_p=64501cab-612b-4577-b46e-8186c9dd6191&pf_rd_i=FMCDummyValue"),
	CHILLED_READY_MEALS_SOUPS("Chilled Ready Meals & Soups",
			"https://www.amazon.co.uk/fmc/category/ref=cg_banyantc_2a1_w?almBrandId=QW1hem9uIEZyZXNo&node=9637043031&pf_rd_m=A3P5ROKL5A1OLE&pf_rd_s=alm-storefront-desktop-bottom-4&pf_rd_r=G5YD2JG8QM3HH785Y848&pf_rd_t=0&pf_rd_p=64501cab-612b-4577-b46e-8186c9dd6191&pf_rd_i=FMCDummyValue"),
	FROZEN("Frozen",
			"https://www.amazon.co.uk/fmc/category/ref=cg_banyantc_2b1_w?almBrandId=QW1hem9uIEZyZXNo&node=6859868031&pf_rd_m=A3P5ROKL5A1OLE&pf_rd_s=alm-storefront-desktop-bottom-4&pf_rd_r=G5YD2JG8QM3HH785Y848&pf_rd_t=0&pf_rd_p=64501cab-612b-4577-b46e-8186c9dd6191&pf_rd_i=FMCDummyValue");

	private String categoryName;
	private String categoryLink;

	private AmazonLink(String categoryName, String categoryLink) {
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
