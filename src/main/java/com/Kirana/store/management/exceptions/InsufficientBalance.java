package com.Kirana.store.management.exceptions;

public class InsufficientBalance extends RuntimeException{

    public InsufficientBalance(String message){
        super(message);
    }
}
