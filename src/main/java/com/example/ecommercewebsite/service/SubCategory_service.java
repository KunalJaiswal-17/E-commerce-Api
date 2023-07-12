package com.example.ecommercewebsite.service;

import com.example.ecommercewebsite.model.Category;
import com.example.ecommercewebsite.model.Product;
import com.example.ecommercewebsite.model.SubCategory;
import com.example.ecommercewebsite.repository.Category_Repo;
import com.example.ecommercewebsite.repository.SubCategory_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubCategory_service {
    @Autowired
    private Category_Repo categoryRepo;

    @Autowired
    private SubCategory_Repo subCategoryRepo;



    @Autowired
    private Category_service categoryService;

    public ResponseEntity<SubCategory> getSubCategoryById(Long id){
        Optional<SubCategory> subCategoryObj = subCategoryRepo.findById(id);
        try{
            if(subCategoryObj.isPresent()){
                return new ResponseEntity<>(subCategoryObj.get(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<SubCategory>> findSubCatByCatId(Long categoryId){
        List<SubCategory> objSubCat = subCategoryRepo.findByCategoryId(categoryId);
        return new ResponseEntity<>(objSubCat, HttpStatus.OK);
    }

    public Object SubCategory(SubCategory subCategory, String name){
        Optional<Category> data = categoryRepo.findBycategoryName(name);
        Category category = data.get();
        subCategory.setCategory(category);
        subCategoryRepo.save(subCategory);
        try{
            String msg1 = "Sub-Category Added\n";
            return new ResponseEntity<>(msg1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<SubCategory>> getAllSubCategory(){
        try{
            List<SubCategory> subCategories = new ArrayList<>();
            subCategoryRepo.findAll().forEach(subCategories::add);

            if(subCategories.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(subCategories, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Object updateSubCategoryByName(String name, SubCategory newData){
        Optional<SubCategory> oldData = subCategoryRepo.findBysubCategoryName(name);
        try {
            if (oldData.isPresent()){
                SubCategory updatedData = oldData.get();
                updatedData.setSubCategoryName(newData.getSubCategoryName());

                SubCategory subCatData = subCategoryRepo.save(updatedData);

                String msg = "Data is Updated.";
                return new ResponseEntity<>(msg, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<SubCategory> deleteSubCategoryByName(String name){
        try {
            Optional<SubCategory> subCategoryId = subCategoryRepo.findBysubCategoryName(name);
            if (subCategoryId.isPresent()) {
                subCategoryRepo.delete(subCategoryId.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<SubCategory> deleteSubCategoryById(Long id){
        try {
            Optional<SubCategory> subCategoryId = subCategoryRepo.findById(id);
            if (subCategoryId.isPresent()) {
                subCategoryRepo.delete(subCategoryId.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
