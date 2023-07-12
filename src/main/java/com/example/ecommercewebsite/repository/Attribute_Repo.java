package com.example.ecommercewebsite.repository;
import com.example.ecommercewebsite.model.Attribute;
import com.example.ecommercewebsite.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Attribute_Repo extends JpaRepository<Attribute, Long> {
    Attribute findByValueIgnoreCaseAndProduct(String lowerProperty, Product product);
}
