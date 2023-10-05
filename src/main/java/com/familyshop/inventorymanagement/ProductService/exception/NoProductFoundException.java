package com.familyshop.inventorymanagement.ProductService.exception;

public class NoProductFoundException extends RuntimeException{
    public NoProductFoundException(String message) {
        super(message);
    }
}
