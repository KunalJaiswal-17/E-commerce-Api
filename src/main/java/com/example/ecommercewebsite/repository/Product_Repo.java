package com.example.ecommercewebsite.repository;

import com.example.ecommercewebsite.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_Repo extends JpaRepository<Product, Long> {
}
