package com.familyshop.inventorymanagement.ProductService.service;

import com.familyshop.inventorymanagement.ProductService.dto.ProductDto;
import com.familyshop.inventorymanagement.ProductService.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product getProductById(int id) throws Exception;
    public void createProduct(ProductDto product) throws Exception;
    public void updateProductById(int productId, ProductDto product);
    public void updateProductByIdAndDate(int productId, String date, ProductDto product) throws Exception;


}
