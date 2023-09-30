package com.familyshop.inventorymanagement.UserService.model;

import javax.persistence.Entity;
import javax.persistence.Table;


public class ContactDetails {

    private Integer phoneNumber;
    private String email;
    private String address;

    public ContactDetails() {
    }

    public ContactDetails(int phoneNumber, String email, String address) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
