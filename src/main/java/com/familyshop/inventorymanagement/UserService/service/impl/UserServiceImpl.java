package com.familyshop.inventorymanagement.UserService.service.impl;

import com.familyshop.inventorymanagement.UserService.dto.UserDto;
import com.familyshop.inventorymanagement.UserService.exception.NoUsersInRepositoryException;
import com.familyshop.inventorymanagement.UserService.exception.RoleNotFoundException;
import com.familyshop.inventorymanagement.UserService.exception.UserNotFoundException;
import com.familyshop.inventorymanagement.UserService.model.ContactDetails;
import com.familyshop.inventorymanagement.UserService.model.Role;
import com.familyshop.inventorymanagement.UserService.model.UserEntity;
import com.familyshop.inventorymanagement.UserService.repository.RoleRepository;
import com.familyshop.inventorymanagement.UserService.repository.UserRepository;
import com.familyshop.inventorymanagement.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<UserEntity> getAllUsers() throws Exception {
        List<UserEntity> allUsers = userRepository.findAll();

        if (allUsers.isEmpty()) {
            throw new NoUsersInRepositoryException("No Users found in repo", new Date().toString());
        }

        return allUsers;
    }

    @Override
    public UserEntity getUserById(int id) throws Exception {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException("No User found with Id: " + id));
    }

    @Override
    public void createUser(UserDto userDto, String role) {
        Optional<Role> roleByName = roleRepository.findRoleByName(role);

        if (roleByName.isEmpty()) {
            throw new RoleNotFoundException("The role specified in not found or created");
        }

        ContactDetails contactDetails = new ContactDetails(userDto.getPhone(),
                userDto.getEmail(), userDto.getAddress());
        UserEntity user = new UserEntity(userDto.getName(), roleByName.get(), contactDetails);

        userRepository.save(user);

    }

    @Override
    public void updateUserById(int id, UserDto userDto) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found by Id:" +id);
        }
        UserEntity userEntity = updateUser(user.get(), userDto);
        userRepository.save(userEntity);
    }

    @Override
    public void updateUserByName(String name, UserDto userDto) {
        Optional<UserEntity> user = userRepository.findUserEntitiesByName(name);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found by name:" +name);
        }
        UserEntity userEntity = updateUser(user.get(), userDto);
        userRepository.save(userEntity);
    }

    private UserEntity updateUser(UserEntity user, UserDto userDto) {
        if (null != userDto.getName()) {
            user.setName(userDto.getName());
        }
        if (null != userDto.getPhone()) {
            user.getContactDetails().setPhoneNumber(userDto.getPhone());
        }
        if (null != userDto.getAddress()) {
            user.getContactDetails().setAddress(userDto.getAddress());
        }
        if (null != userDto.getEmail()) {
            user.getContactDetails().setEmail(userDto.getEmail());
        }

        return user;
    }
}
