package com.familyshop.inventorymanagement.UserService.controller;

import com.familyshop.inventorymanagement.UserService.dto.UserDto;
import com.familyshop.inventorymanagement.UserService.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserControllerV1 {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() throws Exception {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) throws Exception {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createNewUser(@RequestBody @Valid UserDto userDto, @RequestParam String role) {
        userService.createUser(userDto, role);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable int id, @RequestBody @Valid UserDto userDto) {
        userService.updateUserById(id, userDto);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<?> updateUserByName(@RequestParam String name, @RequestBody @Valid UserDto userDto) {
        userService.updateUserByName(name, userDto);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
