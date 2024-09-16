package com.cart.Spring_boot_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.Spring_boot_cart.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{



}

