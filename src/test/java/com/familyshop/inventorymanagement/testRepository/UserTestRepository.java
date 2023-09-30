package com.familyshop.inventorymanagement.testRepository;

import com.familyshop.inventorymanagement.UserService.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTestRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findUserEntitiesByName(String name);
}
