package com.Kirana.store.management.controller;

import com.Kirana.store.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class ProductController {

    @Autowired
   private ProductService productService;

    /**
     *
     *  REST endpoint to  add a Product in the Kirana Store.
     *
     * @param name Name of the Product
     * @param price  Price of the product
     * @param stock  Stock of the Product
     * @return Message
     */
    @PostMapping("/addproduct")
    public String addProduct(@RequestParam String name, @RequestParam double price, @RequestParam int stock){
        return productService.addProduct(name, price, stock);
    }
}
