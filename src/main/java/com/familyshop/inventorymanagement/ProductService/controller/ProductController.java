package com.familyshop.inventorymanagement.ProductService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/item")
    public ResponseEntity<?> getItems() {
        return new ResponseEntity<>("All Items", HttpStatus.OK);
    }
}
