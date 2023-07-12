package com.example.ecommercewebsite.repository;

import com.example.ecommercewebsite.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Category_Repo extends JpaRepository<Category, Long> {
    Optional<Category> findBycategoryName(String name);
}
