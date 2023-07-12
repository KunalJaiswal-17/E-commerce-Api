package com.example.ecommercewebsite.controller;

import com.example.ecommercewebsite.model.Category;
import com.example.ecommercewebsite.model.Product;
import com.example.ecommercewebsite.repository.Product_Repo;
import com.example.ecommercewebsite.repository.SubCategory_Repo;
import com.example.ecommercewebsite.service.Product_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Product_controller {
    @Autowired
    private SubCategory_Repo subCategoryRepo;

    @Autowired
    private Product_Repo productRepo;

    @Autowired
    private Product_service productService;

    @PostMapping("/addProduct/{name}")
    public Object addProduct(@RequestBody Product product, @PathVariable String name) {
        return productService.createProductByName(product, name);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> productById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> all_products(){
        return productService.getAllProduct();
    }

    @PutMapping("/updateProduct/{id}")
    public Object updateProduct(@PathVariable Long id, @RequestBody Product newData){
        return productService.updateProductById(id, newData);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        return productService.deleteProductById(id);
    }
}
