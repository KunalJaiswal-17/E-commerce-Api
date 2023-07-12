package com.example.ecommercewebsite.controller;

import com.example.ecommercewebsite.model.Category;
import com.example.ecommercewebsite.repository.Category_Repo;
import com.example.ecommercewebsite.service.Category_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Category_controller {

    @Autowired
    private Category_Repo categoryRepo;

    @Autowired
    private Category_service categoryService;

    @PostMapping("/addCategory")
    public Object add_category(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @GetMapping("/getCategory")
    public ResponseEntity<List<Category>> all_category(){
        return categoryService.getCategory();
    }

    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<Category> categoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/deleteCategory/{name}")
    public ResponseEntity<Category> deleteByName(@PathVariable String name){
        return categoryService.deleteCategoryByName(name);
    }

    @DeleteMapping("/deleteCategoryId/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable Long id){
        return categoryService.deleteCategoryById(id);
    }

    @PutMapping("/updateCategory/{name}")
    public Object updateById(@PathVariable String name, @RequestBody Category newData){
        return categoryService.updateCategoryByName(name, newData);
    }

}
