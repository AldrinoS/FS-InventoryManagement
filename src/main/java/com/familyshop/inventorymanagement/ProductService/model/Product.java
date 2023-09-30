package com.familyshop.inventorymanagement.ProductService.model;

import java.util.List;

public class Product {

    private int id;
    private String name;
    private String desc;
    private List<ProductDetail> productDetailList;

    public Product() {
    }

    public Product(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<ProductDetail> getItemDetailList() {
        return productDetailList;
    }

    public void setItemDetailList(List<ProductDetail> productDetailList) {
        this.productDetailList = productDetailList;
    }
}
