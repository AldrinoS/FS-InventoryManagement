package com.familyshop.inventorymanagement.ProductService.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String desc;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ProductDetail> productDetailList;

    public Product() {
    }

    public Product(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.productDetailList = new ArrayList<>();
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
