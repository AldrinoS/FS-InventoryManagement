package com.familyshop.inventorymanagement.ProductService.repository;

import com.familyshop.inventorymanagement.ProductService.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
}
