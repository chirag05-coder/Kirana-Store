package com.Kirana.store.management.controller;

import com.Kirana.store.management.entity.Transaction;
import com.Kirana.store.management.entity.TransactionRequest;
import com.Kirana.store.management.entity.TransactionResponse;
import com.Kirana.store.management.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    /**
     * REST endpoint to facilitate a product purchase transaction.
     * This endpoint allows clients to submit a POST request with a JSON payload
     * containing customer information and a map of products to be purchased.
     * Example Request JSON:
     * {
     *   "customer": {
     *     "name": "John Doe",
     *     "email": "john@example.com",
     *     "balance": 500.0
     *   },
     *   "products": {
     *     "Chocolate": 2,
     *     "Lays": 1
     *   }
     * }
     *
     * Example Response JSON:
     * {
     *   "productList": {
     *     "Chocolate": 2,
     *     "Lays": 1
     *   },
     *   "remainingBalance": 390.0,
     *   "message": "Thanks for your visit !!"
     * }
     */
    @PostMapping("/buyproducts")
    public TransactionResponse buyProducts(@RequestBody TransactionRequest request){

        return transactionService.buyProduct(request);
    }

    /**
    * * REST endpoint to retrieve a list of all transactions in the system.
    **/
    @GetMapping("/allTransactions")
    public List<Transaction> getAllTransactions() {
     return transactionService.getAllTransactions();
    }
}
