package com.familyshop.inventorymanagement.ProductService.model;

import com.familyshop.inventorymanagement.UserService.model.UserEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float costPrice;
    private float sellingPrice;
    private float count;
    private String unit;
    private String purchaseDate;
    @OneToOne(fetch = FetchType.EAGER)
    private UserEntity supplier;

    public ProductDetail() {
    }

    public ProductDetail(float costPrice, float sellingPrice, float count, String unit, UserEntity supplier) {
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.count = count;
        this.unit = unit;
        this.supplier = supplier;
        this.purchaseDate = new Date().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public UserEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(UserEntity supplier) {
        this.supplier = supplier;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
