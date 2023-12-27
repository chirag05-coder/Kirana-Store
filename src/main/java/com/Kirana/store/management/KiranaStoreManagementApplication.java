package com.Kirana.store.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KiranaStoreManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(KiranaStoreManagementApplication.class, args);
	}

	/**
	Project Overview

	1.) Entities:

	- Customer Entity:
	 Represents a customer in the system with properties such as id, name, email, and balance.

	-Product Entity:
	 Represents a product with properties including id, name, price, and stock.


	-Transaction Entity:
	Represents a transaction with properties such as id, amount, description, and a reference to the associated Customer.
	Establishes a many-to-one relationship with the Customer entity.

	 -TransactionRequest:
	 Represents the request object for initiating a transaction.
	 Contains a Customer and a Map<String, Integer> for products and quantities.

	 -TransactionResponse:

	 Represents the response object for a completed transaction.
	 Contains a Map<String, Integer> for purchased products, remainingBalance, and a message.


	2.)Repositories:

	Provides repository interfaces for each entity (e.g., CustomerRepository, ProductRepository, TransactionRepository).
	Extends the Spring Data JPA JpaRepository for convenient database operations.

	 3.) Services:

	 -ProductService:
	 Manages product-related operations, such as adding new products or updating existing ones.
	Includes methods like addProduct and custom queries for updating stock and price.

	 -TransactionService:
	Handles transaction-related operations, including purchasing products and retrieving transaction history.
	Implements methods like buyProduct for processing product transactions.

	 The main functionality of the service is encapsulated in the buyProduct method.
	 This method processes a transaction for purchasing products, involving a customer, product quantities, and validation checks.
	 It involves operations such as updating product stock, checking product availability, deducting the purchase amount from the customer's balance, and recording the transaction details.
	 The service follows a transactional pattern to maintain data consistency during complex operations involving multiple entities.

	 4.)Controllers:

	-ProductController:
	 Exposes REST endpoints for product-related operations.
	Includes methods like addProduct to add or update products.

	 -TransactionController:
	 Exposes REST endpoints for transaction-related operations.
	Includes methods like buyProducts to initiate product purchases.
	Provides an endpoint getAllTransactions to retrieve a list of all transactions.
	Request and Response Objects:


	 **/

}
