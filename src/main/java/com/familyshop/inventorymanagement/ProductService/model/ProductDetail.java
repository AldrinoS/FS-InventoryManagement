package com.familyshop.inventorymanagement.ItemService.model;

public class ItemDetail {

    private int id;
    private float costPrice;
    private float sellingPrice;
    private float count;
    private String unit;

    public ItemDetail() {
    }

    public ItemDetail(float costPrice, float sellingPrice, float count, String unit) {
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.count = count;
        this.unit = unit;
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
}
