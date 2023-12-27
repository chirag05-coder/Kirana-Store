package com.Kirana.store.management.exceptions;

public class ProductNotAvailable extends RuntimeException{

    public ProductNotAvailable(String message){
        super(message);
    }
}
