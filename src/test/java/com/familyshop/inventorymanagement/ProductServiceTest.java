//package com.familyshop.inventorymanagement;
//
//import com.familyshop.inventorymanagement.ProductService.dto.ProductDto;
//import com.familyshop.inventorymanagement.ProductService.model.Product;
//import com.familyshop.inventorymanagement.UserService.dto.UserDto;
//import com.familyshop.inventorymanagement.UserService.model.UserEntity;
//import com.familyshop.inventorymanagement.UserService.repository.UserRepository;
//import com.familyshop.inventorymanagement.testRepository.ProductDetailTestRepository;
//import com.familyshop.inventorymanagement.testRepository.ProductTestRepository;
//import com.familyshop.inventorymanagement.testRepository.ProductUserTestRepository;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.assertEquals;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ProductServiceTest {
//
//    @LocalServerPort
//    private int port;
//
//    private String baseUrl = "http://localhost";
//
//    private static RestTemplate restTemplate;
//
//    @Autowired
//    private ProductTestRepository productRepository;
//
//    @Autowired
//    private ProductDetailTestRepository productDetailTestRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @BeforeAll
//    public static void init() {
//        restTemplate = new RestTemplate();
//    }
//
//    @BeforeEach
//    public void setUp() {
//        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/v1/products");
//    }
//
//
//    @Test
//    public void testAddSupplierUser() {
//        UserDto supplier = new UserDto();
//        supplier.setName("Supplier 1");
//        supplier.setPhone(123423789);
//        supplier.setEmail("supplierone@gmail.com");
//        supplier.setAddress("Queens Street");
//        restTemplate.postForObject("http://localhost:"+port+"/api/v1/users" + "?role=SUPPLIER", supplier, UserDto.class);
//        Optional<UserEntity> user = userRepository.findById(1);
//
//        assertEquals("Supplier 1", user.get().getName());
//        assertEquals(1, userRepository.findAll().size());
//    }
//
//    @Test
//    public void testAddNewProduct() {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Product A");
//        productDto.setDesc("Description for Product A");
//        productDto.setQuantity(12F);
//        productDto.setSupplier(1);
//        productDto.setSellingPrice(13.4F);
//        productDto.setCostPrice(12.4F);
//        productDto.setUnit("kg");
//
//        restTemplate.postForObject(baseUrl, productDto, ProductDto.class);
//        Optional<Product> product = productRepository.findById(1);
//
//        assertEquals("Product A", product.get().getName());
//        assertEquals(1, productRepository.findAll().size());
//    }
//
//    @Test
//    public void testGetAllProducts() {
//        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
//                baseUrl,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Product>>() {
//                }
//        );
//
//        List<Product> products = responseEntity.getBody();
//        assertEquals(1, products.size());
//    }
//
//    @Test
//    public void getProductById() {
//        Product product = restTemplate.getForObject(baseUrl + "/1", Product.class);
//
//        assertEquals("Product A", product.getName());
//        assertEquals(12F, product.getItemDetailList().get(0).getCount());
//
//    }
//
//    @Test
//    public void updateProductById() {
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Product B");
//        productDto.setDesc("Description for Product B");
//
//        restTemplate.put(baseUrl+"/1", productDto, ProductDto.class);
//        Optional<Product> product = productRepository.findById(1);
//
//        assertEquals("Product B", product.get().getName());
//        assertEquals(1, productRepository.findAll().size());
//    }
//
//    @Test
//    public void updateProductByIdAndDate() {
//        Product product1 = productRepository.findById(1).get();
//        ProductDto productDto = new ProductDto();
//        productDto.setQuantity(13F);
//        productDto.setSupplier(1);
//        productDto.setSellingPrice(12.4F);
//        productDto.setCostPrice(11.4F);
//        productDto.setUnit("count");
//
//        restTemplate.put(baseUrl+"?productId=1&"+"date="+product1.getItemDetailList().get(1).getPurchaseDate(), productDto, ProductDto.class);
//        Optional<Product> product = productRepository.findById(1);
//
//        assertEquals(13F, product.get().getItemDetailList().get(0).getCount());
//    }
//}
