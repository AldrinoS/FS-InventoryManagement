package com.familyshop.inventorymanagement.UserService.repository;

import com.familyshop.inventorymanagement.UserService.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findUserEntitiesByName(String name);
}
