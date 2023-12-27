package com.Kirana.store.management.exceptions;

public class OutOfStock extends RuntimeException{

    public OutOfStock(String message){
        super(message);
    }
}
