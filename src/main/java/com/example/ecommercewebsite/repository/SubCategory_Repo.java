package com.example.ecommercewebsite.repository;

import com.example.ecommercewebsite.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubCategory_Repo extends JpaRepository<SubCategory, Long> {
    Optional<SubCategory> findBysubCategoryName(String name);

    @Query("SELECT p FROM SubCategory p WHERE p.category.id= :categoryId")
    List<SubCategory> findByCategoryId(@Param("categoryId")Long categoryId);

}
