package com.cart.SpringbootCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.SpringbootCart.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{



}

