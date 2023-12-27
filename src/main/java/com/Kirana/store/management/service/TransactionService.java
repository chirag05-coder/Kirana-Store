package com.Kirana.store.management.service;

import com.Kirana.store.management.entity.*;
import com.Kirana.store.management.exceptions.InsufficientBalance;
import com.Kirana.store.management.exceptions.InsufficientStock;
import com.Kirana.store.management.exceptions.ProductNotAvailable;
import com.Kirana.store.management.repository.CustomerRepository;
import com.Kirana.store.management.repository.ProductRepository;
import com.Kirana.store.management.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    /**
     * Service method to facilitate a product purchase transaction.
     * This method performs the following steps:
     * 1. Saves the customer information in the database.
     * 2. Validates product availability and updates stock levels.
     * 3. Checks and deducts the required amount from the customer's balance.
     * 4. Records the transaction details in the database.
     * 5. Generates a response with a list of purchased products, remaining balance, and a thank you message.
     *
     * @param request The transaction request containing customer information and a products to be purchased.
     * @return A TransactionResponse object containing details of the completed transaction.
     * @throws ProductNotAvailable If a product is not available in the Kirana Store.
     * @throws InsufficientStock If there is insufficient stock for a product in the store.
     * @throws InsufficientBalance If the customer has insufficient balance to complete the transaction.
     */
    @Transactional
    public TransactionResponse buyProduct(TransactionRequest request){
        Customer customer = request.getCustomer();
        Map<String,Integer> products = request.getProducts();

            customerRepository.save(customer);

        double amount = 0;
        for(Map.Entry<String, Integer> product : products.entrySet()) {
            String name = product.getKey();
            Integer stock = product.getValue();
            Product fetchProduct = productRepository.findByName(name);

            if(fetchProduct == null){
                throw new ProductNotAvailable("Product is not Available in the Kirana Store");
            }

            if(stock > fetchProduct.getStock()){
                throw new InsufficientStock("InSufficient Stock in the Store");
            }
            amount += fetchProduct.getPrice()*stock;
            fetchProduct.setStock(fetchProduct.getStock() - stock);
            productRepository.save(fetchProduct);
        }

        if(amount > customer.getBalance()){
            throw new InsufficientBalance("Hey Customer you have insufficient Balance");
        }
        Transaction transaction = Transaction.builder().amount(amount)
                        .description("Purchased Products")
                .customer(customer)
                                .build();
        transactionRepository.save(transaction);

        TransactionResponse transactionResponse = TransactionResponse.builder()
                .productList(products)
                .remainingBalance(customer.getBalance() - amount)
                .message("Thanks for your visit !!")
                .build();
        return transactionResponse;
    }

    /**
     * Function to return all the trasactions made in the Kirana Store
     * @return List of Transactions
     */
    public List<Transaction> getAllTransactions(){

        return transactionRepository.findAll();
    }
}
