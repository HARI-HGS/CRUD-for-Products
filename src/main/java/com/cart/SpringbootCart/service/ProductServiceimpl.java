package com.cart.SpringbootCart.service;


import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.SpringbootCart.entity.Products;
import com.cart.SpringbootCart.repository.ProductRepository;



@Service
public class ProductServiceimpl implements ProductService{

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceimpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Products saveProducts(Products products) {
        logger.info("Saving product: {}", products);
        logger.error("error",products);
        return productRepository.save(products);
    }

    @Override
    public List<Products> fetchProductsList() {
        logger.info("Fetching products list");
        return productRepository.findAll();
    }

    @Override
    public Products fetchProductsListById(Long productId) {
        logger.info("Fetching product by Id: {}", productId);
       return productRepository.findById(productId).get();
    }

    @Override
    public void deleteProductsById(Long productId) {
        logger.info("Deleting product by Id: {}", productId);
        productRepository.deleteById(productId);
    }

    @Override
    public Products updateProducts(Long productId, Products products) {
       
        logger.info("Updating product by Id: {}", productId); 

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
