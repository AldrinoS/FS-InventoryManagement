package com.familyshop.inventorymanagement;

import com.familyshop.inventorymanagement.UserService.dto.UserDto;
import com.familyshop.inventorymanagement.UserService.model.UserEntity;
import com.familyshop.inventorymanagement.UserService.repository.UserRepository;
import com.familyshop.inventorymanagement.testRepository.UserTestRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;

    @Autowired
    private UserTestRepository userRepository;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/v1/users");
    }


    @Test
    public void testAddCustomerUser() {
        UserDto customer = new UserDto();
        customer.setName("Customer 1");
        customer.setPhone(123456789);
        customer.setEmail("customerone@gmail.com");
        customer.setAddress("Queens Street");
        restTemplate.postForObject(baseUrl + "?role=CUSTOMER", customer, UserDto.class);
        Optional<UserEntity> user = userRepository.findById(1);

        assertEquals("Customer 1", user.get().getName());
        assertEquals(1, userRepository.findAll().size());
    }

    @Test
    public void testAddSupplierUser() {
        UserDto supplier = new UserDto();
        supplier.setName("Supplier 1");
        supplier.setPhone(123423789);
        supplier.setEmail("supplierone@gmail.com");
        supplier.setAddress("Queens Street");
        restTemplate.postForObject(baseUrl + "?role=SUPPLIER", supplier, UserDto.class);
        Optional<UserEntity> user = userRepository.findById(2);

        assertEquals("Supplier 1", user.get().getName());
        assertEquals(2, userRepository.findAll().size());
    }

    @Test
    public void testAddAdminUser() {
        UserDto admin = new UserDto();
        admin.setName("Admin 1");
        admin.setPhone(123459999);
        admin.setEmail("admin@gmail.com");
        admin.setAddress("Queens Street");
        restTemplate.postForObject(baseUrl + "?role=ADMIN", admin, UserDto.class);
        Optional<UserEntity> user = userRepository.findById(3);

        assertEquals("Admin 1", user.get().getName());
        assertEquals(3, userRepository.findAll().size());
    }

    @Test
    public void testUserRepositorySize() {
        int size = userRepository.findAll().size();
        assertEquals(3, size);

    }


//    @Test
    public void testUpdateCustomerDetails() {
        UserDto customer = new UserDto();
        customer.setName("Customer 2");
        customer.setPhone(123123123);
        customer.setEmail("customertwo@gmail.com");
        customer.setAddress("Queens City");

        restTemplate.put(baseUrl + "/{id}", customer, 1);
        Optional<UserEntity> user = userRepository.findById(1);

        assertEquals("Customer 2", user.get().getName());
        assertEquals("123123123", user.get().getContactDetails().getPhoneNumber().toString());
        assertEquals("Queens City", user.get().getContactDetails().getAddress());
        assertEquals("customertwo@gmail.com", user.get().getContactDetails().getEmail());

        assertEquals(3, userRepository.findAll().size());
    }


//    @Test
    public void testUpdateSupplierDetails() {
        UserDto supplier = new UserDto();
        supplier.setName("Supplier 2");
        supplier.setPhone(123123123);
        supplier.setEmail("suppliertwo@gmail.com");
        supplier.setAddress("Queens City");

        restTemplate.put(baseUrl + "/{id}", supplier,2);
        Optional<UserEntity> user = userRepository.findById(2);

        assertEquals("Supplier 2", user.get().getName());
        assertEquals("123123123", user.get().getContactDetails().getPhoneNumber().toString());
        assertEquals("Queens City", user.get().getContactDetails().getAddress());
        assertEquals("suppliertwo@gmail.com", user.get().getContactDetails().getEmail());

        assertEquals(3, userRepository.findAll().size());
    }

//    @Test
    public void testUpdateAdminDetails() {
        UserDto admin = new UserDto();
        admin.setName("Admin 2");
        admin.setPhone(123123123);
        admin.setEmail("Admintwo@gmail.com");
        admin.setAddress("Queens City");

        restTemplate.put(baseUrl + "/{id}", admin,3);
        Optional<UserEntity> user = userRepository.findById(3);

        assertEquals("Admin 2", user.get().getName());
        assertEquals("123123123", user.get().getContactDetails().getPhoneNumber().toString());
        assertEquals("Queens City", user.get().getContactDetails().getAddress());
        assertEquals("Admintwo@gmail.com", user.get().getContactDetails().getEmail());

        assertEquals(3, userRepository.findAll().size());
    }
}
