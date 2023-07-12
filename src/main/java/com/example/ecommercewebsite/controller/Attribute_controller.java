package com.example.ecommercewebsite.controller;

import com.example.ecommercewebsite.model.Attribute;
import com.example.ecommercewebsite.repository.Attribute_Repo;
import com.example.ecommercewebsite.repository.Product_Repo;
import com.example.ecommercewebsite.service.Attribute_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class Attribute_controller {
    @Autowired
    private Attribute_Repo attributeRepo;

    @Autowired
    private Product_Repo productRepo;

    @Autowired
    private Attribute_service attributeService;

    @PostMapping("/addAttribute/{Id}")
    public Object addProduct(@RequestBody Attribute attribute, @PathVariable Long Id) {
        return attributeService.createAttribute(attribute, Id);
    }
}
