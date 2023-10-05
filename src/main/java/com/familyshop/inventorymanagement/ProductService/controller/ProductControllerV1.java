package com.familyshop.inventorymanagement.ProductService.controller;

import com.familyshop.inventorymanagement.ProductService.dto.ProductDto;
import com.familyshop.inventorymanagement.ProductService.model.Product;
import com.familyshop.inventorymanagement.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductControllerV1 {

    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<?> getItems() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(name = "id") int id) throws Exception {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> createNewProduct(@RequestBody ProductDto productDto) throws Exception {
        productService.createProduct(productDto);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProductNameAndDesc(@RequestBody ProductDto productDto, @PathVariable int id) {
        productService.updateProductById(id, productDto);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PutMapping("/products")
    public ResponseEntity<?> updateProductDetails(@RequestParam int productId, @RequestBody ProductDto productDto,
                                                  @RequestParam String date) throws Exception {
        productService.updateProductByIdAndDate(productId, date, productDto);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
