package com.test.ws.business;

import java.util.ArrayList;
import java.util.List;

import com.test.ws.model.Product;

public class ProductServiceImpl {

	List<String> booksList = new ArrayList<String>();
	List<String> phoneList = new ArrayList<String>();
	List<String> movieList = new ArrayList<String>();

	public ProductServiceImpl() {

		booksList.add("book1");
		phoneList.add("phone1");
		movieList.add("movie1");

		booksList.add("book2");
		phoneList.add("phone2");
		movieList.add("movie2");

		booksList.add("book3");
		phoneList.add("phone3");
		movieList.add("movie3");
	}

	public List<String> getProductCategories() {
		List<String> list = new ArrayList<String>();

		list.add("book");
		list.add("phone");
		list.add("movie");

		return list;
	}

	public List<String> getProductsListByCategory(String category) {

		if (category.equals("book"))
			return booksList;
		else if (category.equals("phone"))
			return phoneList;
		else if (category.equals("movie"))
			return movieList;

		return null;

	}

	public boolean addProduct(String category, String product) {

		if (category != null) {
			if (category.equals("book"))
				booksList.add(product);
			else if (category.equals("phone"))
				phoneList.add(product);
			else if (category.equals("movie"))
				movieList.add(product);
			return true;
		} else

			return false;
	}

	public List<Product> getProductsListByCategoryV2(String category) {
		List<Product> list = new ArrayList<Product>();

		list.add(new Product("ramesh1", "12424", 123143));
		list.add(new Product("ramesh2", "12424", 123143));
		list.add(new Product("ramesh3", "12424", 123143));

		return list;

	}

}
