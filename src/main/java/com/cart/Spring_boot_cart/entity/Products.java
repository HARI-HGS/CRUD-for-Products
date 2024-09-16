package com.cart.Spring_boot_cart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private Double price;
    private String discription;


    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    public Products(Long productId, String productName, Double price, String discription) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.discription = discription;
    }

    public Products(){

    }
    @Override
    public String toString() {
        return "Products {productId=" + productId + 
        ", productName=" + productName + 
        ", price=" + price+ 
        ", discription=" + discription 
        + "}";
    }



}
