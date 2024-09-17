package com.cart.SpringbootCart.service;

import java.util.List;

import com.cart.SpringbootCart.entity.Products;

public interface ProductService {

   public Products saveProducts(Products products);

   public List<Products> fetchProductsList();

   public Products fetchProductsListById(Long productId);

   public void deleteProductsById(Long productId);

   public Products updateProducts(Long productId, Products products);





}
