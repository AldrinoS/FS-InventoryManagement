package com.familyshop.inventorymanagement.testRepository;

import com.familyshop.inventorymanagement.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTestRepository extends JpaRepository<Product, Integer> {
}
