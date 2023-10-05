package com.familyshop.inventorymanagement.ProductService.service.impl;

import com.familyshop.inventorymanagement.ProductService.dto.ProductDto;
import com.familyshop.inventorymanagement.ProductService.exception.NoProductFoundException;
import com.familyshop.inventorymanagement.ProductService.exception.ProductNotUpdatedException;
import com.familyshop.inventorymanagement.ProductService.model.Product;
import com.familyshop.inventorymanagement.ProductService.model.ProductDetail;
import com.familyshop.inventorymanagement.ProductService.repository.ProductDetailRepository;
import com.familyshop.inventorymanagement.ProductService.repository.ProductRepository;
import com.familyshop.inventorymanagement.ProductService.service.ProductService;
import com.familyshop.inventorymanagement.UserService.model.UserEntity;
import com.familyshop.inventorymanagement.UserService.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        if (allProducts.isEmpty()) {
            throw new NoProductFoundException("No Products in Repository");
        }

        return allProducts;
    }

    @Override
    public Product getProductById(int id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new NoProductFoundException("No Product found with ID: "+id));
    }

    @Override
    public void createProduct(ProductDto product) throws Exception {
        UserEntity supplier = userService.getUserById(product.getSupplier());
        ProductDetail productDetail = new ProductDetail(product.getCostPrice(), product.getSellingPrice(), product.getQuantity(), product.getUnit(), supplier);
        Product newProduct = new Product(product.getName(), product.getDesc());
        newProduct.getItemDetailList().add(productDetail);

        productRepository.save(newProduct);
    }

    @Override
    public void updateProductById(int productId, ProductDto productUpdate) {
        Optional<Product> productById = productRepository.findById(productId);
        if (productById.isPresent()) {
            Product product = productById.get();
            if (null != productUpdate.getName()) {
                product.setName(productUpdate.getName());
            }
            if (null != productUpdate.getDesc()) {
                product.setDesc(productUpdate.getDesc());
            }
            productRepository.save(product);
        } else {
            throw new ProductNotUpdatedException("Product Updating failed");
        }

    }

    @Override
    public void updateProductByIdAndDate(int productId, String date, ProductDto productUpdate) throws Exception {
        Optional<Product> productById = productRepository.findById(productId);
        if (productById.isPresent()) {
            Product product = productById.get();
            Optional<ProductDetail> updateProductDetail = product.getItemDetailList()
                    .stream().filter(productDetail -> productDetail.getPurchaseDate().equals(date)).findFirst();
            if(updateProductDetail.isPresent()) {
                ProductDetail productDetail = updateProduct(updateProductDetail.get(), productUpdate);
                productDetailRepository.save(productDetail);
            }
        } else {
            throw new ProductNotUpdatedException("Product Updating failed");
        }
    }

    private ProductDetail updateProduct(ProductDetail productDetail, ProductDto updateProduct) throws Exception {
        if (null != updateProduct.getSupplier()) {
            UserEntity supplier = userService.getUserById(updateProduct.getSupplier());
            productDetail.setSupplier(supplier);
        }
        if (null != updateProduct.getQuantity()) {
            productDetail.setCount(updateProduct.getQuantity());
        }
        if (null != updateProduct.getUnit()) {
            productDetail.setUnit(updateProduct.getUnit());
        }
        if (null != updateProduct.getCostPrice()) {
            productDetail.setCostPrice(updateProduct.getCostPrice());
        }
        if (null != updateProduct.getSellingPrice()) {
            productDetail.setSellingPrice(updateProduct.getSellingPrice());
        }

        return productDetail;
    }
}
