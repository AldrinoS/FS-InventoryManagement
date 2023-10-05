package com.familyshop.inventorymanagement.testRepository;

import com.familyshop.inventorymanagement.UserService.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUserTestRepository extends JpaRepository<UserEntity, Integer> {
}
