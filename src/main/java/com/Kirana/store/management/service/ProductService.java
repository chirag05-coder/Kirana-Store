package com.Kirana.store.management.service;

import com.Kirana.store.management.entity.Product;
import com.Kirana.store.management.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    /**
     * Service method to add a new product or update the stock and price of an existing product.
     * This method performs the following steps:
     * 1. Creates a new Product object with the provided name, price, and stock.
     * 2. Checks if a product with the same name already exists in the database.
     *    - If the product exists, updates its stock and price.
     *    - If the product does not exist, saves the new product in the database.
     *
     * @param name  The name of the product.
     * @param price The price of the product.
     * @param stock The stock quantity of the product.
     * @return A success message indicating whether a new product was added or an existing one was updated.
     */
    @Transactional
    public String addProduct(String name, double price , int stock){
        Product product = Product.builder().stock(stock)
                        .price(price)
                                .name(name).build();
        Product fetchProduct = repository.findByName(name);
        if(fetchProduct != null)
        {
            repository.updateStockAndPriceByName(name, stock, price);
        }
        else
        {repository.save(product);}

        return "Product Added SuccessFully";
    }
}
