package com.familyshop.inventorymanagement.UserService.service;

import com.familyshop.inventorymanagement.UserService.dto.UserDto;
import com.familyshop.inventorymanagement.UserService.model.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    public List<UserEntity> getAllUsers() throws Exception;
    public UserEntity getUserById(int id) throws Exception;
    public void createUser(UserDto userDto, String role);
    public void updateUserById(int id, UserDto userDto);
    public void updateUserByName(String name, UserDto userDto);
}
