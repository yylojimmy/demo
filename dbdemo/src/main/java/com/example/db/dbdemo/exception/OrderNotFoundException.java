package com.example.db.dbdemo.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id){
        super("OrderTable id not found :"+id);
    }
}
