package com.cart.Spring_boot_cart.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.Spring_boot_cart.entity.Products;
import com.cart.Spring_boot_cart.repository.ProductRepository;

@Service
public class ProductServiceimpl implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Products saveProducts(Products products) {
        return productRepository.save(products);
    }

    @Override
    public List<Products> fetchProductsList() {
        
        return productRepository.findAll();
    }

    @Override
    public Products fetchProductsListById(Long productId) {
       return productRepository.findById(productId).get();
    }

    @Override
    public void deleteProductsById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Products updateProducts(Long productId, Products products) {
       
        Products productDB = productRepository.findById(productId).get();

        if(Objects.nonNull(products.getProductName()) && !"".equalsIgnoreCase(products.getProductName())){
            productDB.setProductName(products.getProductName());
        }

        if(Objects.nonNull(products.getPrice()) && products.getPrice() != 0.0){
            productDB.setPrice(products.getPrice());
        } 

        if(Objects.nonNull(products.getDiscription()) && !"".equalsIgnoreCase(products.getDiscription())){
            productDB.setDiscription(products.getDiscription());
        }

        return productRepository.save(productDB);
    }
   
   

}
