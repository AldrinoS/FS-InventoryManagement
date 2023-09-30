package com.familyshop.inventorymanagement.ProductService.service;

import com.familyshop.inventorymanagement.ProductService.dto.ProductDto;
import com.familyshop.inventorymanagement.ProductService.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public void createProduct(ProductDto product);
    public void updateProductById(ProductDto product);
    public void updateProductByIdAndDate(ProductDto product);


}
