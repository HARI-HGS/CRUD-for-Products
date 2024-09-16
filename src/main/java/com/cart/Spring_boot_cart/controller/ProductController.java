package com.cart.Spring_boot_cart.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cart.Spring_boot_cart.entity.Products;
import com.cart.Spring_boot_cart.service.ProductService;

@RestController
public class ProductController {

   @Autowired
   private ProductService productService;
   
   @PostMapping("/products")
   public Products saveProducts(@RequestBody Products products){
       
       return productService.saveProducts(products);   
       
   }

    @GetMapping("/products")
    public List<Products> fetchProductsList(){
        return productService.fetchProductsList();
    }

    @GetMapping("/products/{id}")
    public Products fetchProductsListById(@PathVariable("id") Long productId){
        return productService.fetchProductsListById(productId);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProductsById(@PathVariable("id") Long productId){
        productService.deleteProductsById(productId);
        return "Product deleted sucessfully.";

    }

    @PutMapping("/products/{id}")
    public Products updateProducts(@PathVariable("id") Long productId, @RequestBody Products products){
        return productService.updateProducts(productId, products);
    }

    


}