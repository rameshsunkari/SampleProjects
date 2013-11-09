package com.test.ws.beans;

import java.util.List;

import javax.jws.WebService;

import com.test.ws.business.ProductServiceImpl;
import com.test.ws.model.Product;

@WebService(endpointInterface="com.test.ws.beans.ProductCatalogInterface")
public class ProductCatalog implements ProductCatalogInterface {

	ProductServiceImpl productService = new ProductServiceImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.test.ws.beans.ProductCatalogInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories() {
		return productService.getProductCategories();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.test.ws.beans.ProductCatalogInterface#getProductsByCategory(java.
	 * lang.String)
	 */
	@Override
	public List<String> getProductsByCategory(String category) {
		return productService.getProductsListByCategory(category);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.test.ws.beans.ProductCatalogInterface#addProduct(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product) {
		return productService.addProduct(category, product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.test.ws.beans.ProductCatalogInterface#getProductsByCategoryV2(java
	 * .lang.String)
	 */
	@Override
	public List<Product> getProductsByCategoryV2(String category) {
		return productService.getProductsListByCategoryV2(category);
	}
}
