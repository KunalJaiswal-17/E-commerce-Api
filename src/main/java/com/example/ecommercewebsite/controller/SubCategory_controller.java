package com.example.ecommercewebsite.controller;

import com.example.ecommercewebsite.model.Category;
import com.example.ecommercewebsite.model.SubCategory;
import com.example.ecommercewebsite.repository.Category_Repo;
import com.example.ecommercewebsite.repository.SubCategory_Repo;
import com.example.ecommercewebsite.service.Category_service;
import com.example.ecommercewebsite.service.SubCategory_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SubCategory_controller {
    @Autowired
    private Category_Repo categoryRepo;

    @Autowired
    private SubCategory_Repo subCategoryRepo;

    @Autowired
    private SubCategory_service SubCategoryService;

    @PostMapping("/subCategory/{name}")
    public Object addSubCategory(@RequestBody SubCategory subCategory, @PathVariable String name) {
        return SubCategoryService.SubCategory(subCategory, name);
    }

    @GetMapping("/subCatById/{id}")
    public ResponseEntity<SubCategory> getSubCatById(@PathVariable Long id){
        return SubCategoryService.getSubCategoryById(id);
    }

    @GetMapping("/getAllSubCategory")
    public ResponseEntity<List<SubCategory>> all_subCategory(){
        return SubCategoryService.getAllSubCategory();
    }

    @PutMapping("/updateSubCat/{name}")
    public Object updateById(@PathVariable String name, @RequestBody SubCategory newData){
        return SubCategoryService.updateSubCategoryByName(name, newData);
    }

    @DeleteMapping("/deleteSubCat/{name}")
    public ResponseEntity<SubCategory> deleteByName(@PathVariable String name){
        return SubCategoryService.deleteSubCategoryByName(name);
    }
    @DeleteMapping("/deleteSubCatId/{id}")
    public ResponseEntity<SubCategory> deleteById(@PathVariable Long id){
        return SubCategoryService.deleteSubCategoryById(id);
    }

    @GetMapping("/findByCatId/{categoryId}")
    public ResponseEntity<List<SubCategory>> findSubCatByCatId(@PathVariable Long categoryId){
        return SubCategoryService.findSubCatByCatId(categoryId);
    }
}
