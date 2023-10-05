package com.familyshop.inventorymanagement.testRepository;

import com.familyshop.inventorymanagement.ProductService.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailTestRepository extends JpaRepository<ProductDetail, Integer> {
}
