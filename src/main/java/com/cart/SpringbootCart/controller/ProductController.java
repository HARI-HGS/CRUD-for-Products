package com.cart.SpringbootCart.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cart.SpringbootCart.entity.Products;
import com.cart.SpringbootCart.service.DummyRestApiService;
import com.cart.SpringbootCart.service.ProductService;

@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


   @Autowired
   private ProductService productService;

   @Autowired
   private DummyRestApiService dummyRestApiService;
   
   @PostMapping("/products")
   public Products saveProducts(@RequestBody Products products){
       logger.info("Recieved request to save product: {}", products);
       return productService.saveProducts(products);   
       
   }

    @GetMapping("/products")
    public List<Products> fetchProductsList(){
        logger.info("Fetching list of products");
        return productService.fetchProductsList();
    }

    @GetMapping("/products/{id}")
    public Products fetchProductsListById(@PathVariable("id") Long productId){
        logger.info("Fetching product by Id: {}", productId);
        return productService.fetchProductsListById(productId);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProductsById(@PathVariable("id") Long productId){
        logger.info("Deleting product by Id: {}", productId);
        productService.deleteProductsById(productId);
        return "Product deleted sucessfully.";

    }

    @PutMapping("/products/{id}")
    public Products updateProducts(@PathVariable("id") Long productId, @RequestBody Products products){
        logger.info("Updating product by Id: {}", productId);
        return productService.updateProducts(productId, products);
    }

    @GetMapping("/employees")
    public String fetchDummyEmployees(){
        logger.info("Calling dummy Rest Api to fetch data");
        return dummyRestApiService.getEmployess();
    }


}