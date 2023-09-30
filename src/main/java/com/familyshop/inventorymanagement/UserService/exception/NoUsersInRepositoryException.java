package com.familyshop.inventorymanagement.UserService.exception;

public class NoUsersInRepositoryException extends RuntimeException{
    private String date;

    public NoUsersInRepositoryException(String message, String date) {
        super(message);
        this.date = date;
    }
}
