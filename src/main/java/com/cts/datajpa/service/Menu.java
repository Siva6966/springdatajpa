package com.cts.datajpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.datajpa.dao.ProductRepository;
import com.cts.datajpa.model.Product;

@Component
public class Menu {

	private static final Logger log = LoggerFactory.getLogger(Menu.class);

	@Autowired
	private ProductRepository impl;
	private Scanner scanner;

	public Menu() {
		scanner = new Scanner(System.in);
	}
	
	public void createData() {
		List<Product> list = new ArrayList<>();
		Product p = new Product();
		p.setName("Apple");
		p.setDescription("laptop");
		p.setPrice(100000);
		p.setQuantity(10);
		Product p1 = new Product();
		p1.setName("oneplus");
		p1.setDescription("mobile");
		p1.setPrice(100000);
		p1.setQuantity(10);
		list.add(p);
		list.add(p1);
		impl.saveAll(list);
	}

	public void displayMenu() {
		System.out.println("1. Display all products");
		System.out.println("2. Display a single product by id");
		System.out.println("3. Add a new product");
		System.out.println("4. Update an existing product");
		System.out.println("5. Delete a product");
		System.out.println("6. Exit");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			displayAllProducts();
			break;
		case 2:
			displayProductById();
			break;
		case 3:
			addProduct();
			break;
		case 4:
			updateProduct();
			break;
		case 5:
			deleteProduct();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		displayMenu();
	}

	private void displayAllProducts() {
		List<Product> prods = impl.findAll();
		prods.stream().forEach(r -> {
			System.out.println(r.toString());
		});
	}

	private void displayProductById() {
		Optional<Product> product = impl.findById(2);
		Product product2 = product.get();
		System.out.println(product2.toString());
	}

	private void addProduct() {
		Product p = new Product();
		p.setName("Oneplus");
		p.setDescription("Mobile");
		p.setPrice(45000);
		p.setQuantity(10);
		Product save = impl.save(p);
		if (save != null)
			log.info("Product saved **********");
	}

	private void updateProduct() {
		Product p = new Product();
		p.setId(11);
		p.setPrice(50000);
		Product status = impl.save(p);
		if (status != null)
			log.info("Product Updated ********");
	}

	private void deleteProduct() {
		impl.deleteById(11);
		log.info("Product Deeleted **********");
	}
}
