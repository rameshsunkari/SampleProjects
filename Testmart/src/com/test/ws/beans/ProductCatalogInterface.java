package com.test.ws.beans;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.test.ws.model.Product;

@WebService(name="TestmartCatalog", portName="TestMartCatalogPort", 
serviceName="TestMartCatalogService", targetNamespace="http://www.testmart.com")

public interface ProductCatalogInterface {

	@WebMethod(action="fetch categories", operationName="fetchcategories")
	public abstract List<String> getProductCategories();

	@WebMethod
	public abstract List<String> getProductsByCategory(String category);

	@WebMethod
	public abstract boolean addProduct(String category, String product);

	@WebMethod
	public abstract List<Product> getProductsByCategoryV2(String category);

}