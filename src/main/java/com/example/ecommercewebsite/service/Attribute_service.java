package com.example.ecommercewebsite.service;

import com.example.ecommercewebsite.model.Attribute;
import com.example.ecommercewebsite.model.Product;
import com.example.ecommercewebsite.repository.Attribute_Repo;
import com.example.ecommercewebsite.repository.Product_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Attribute_service {
    @Autowired
    private Attribute_Repo attributeRepo;

    @Autowired
    private Product_Repo productRepo;

    public Object createAttribute(Attribute attribute, Long Id){
        Optional<Product> data = productRepo.findById(Id);
        Product product = data.get();
        String lowerProperty = attribute.getProperty().toLowerCase();

        // Check if an attribute with the same property already exists for the product
        Attribute existingAttribute = attributeRepo.findByValueIgnoreCaseAndProduct(lowerProperty, product);
        if (existingAttribute != null) {
            String errorMessage = "Attribute with property '" + attribute.getProperty() + "' already exists.";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        attribute.setProduct(product);
        Attribute attributeData = attributeRepo.save(attribute);
        try{
            String msg = "Attribute Created\n";
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
