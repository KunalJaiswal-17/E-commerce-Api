package com.example.ecommercewebsite.service;

import com.example.ecommercewebsite.model.Category;
import com.example.ecommercewebsite.repository.Category_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Category_service {
    @Autowired
    private Category_Repo categoryRepo;

    public Object addCategory(Category category){
        Category obj = categoryRepo.save(category);
        try{
            String message = "Category Added\n";
            return new ResponseEntity<>(message + obj, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Category>> getCategory(){
        try{
            List<Category> categories = new ArrayList<>();
            categoryRepo.findAll().forEach(categories::add);

            if(categories.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Category> getCategoryById(Long id){
        Optional<Category> categoryObj = categoryRepo.findById(id);
        try{
            if(categoryObj.isPresent()){
                return new ResponseEntity<>(categoryObj.get(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Category> deleteCategoryByName(String name){
        try {
            Optional<Category> categoryName = categoryRepo.findBycategoryName(name);
            if (categoryName.isPresent()) {
                categoryRepo.delete(categoryName.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Category> deleteCategoryById(Long id){
        try {
            Optional<Category> categoryId = categoryRepo.findById(id);
            if (categoryId.isPresent()) {
                categoryRepo.delete(categoryId.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Object updateCategoryByName(String name, Category newData){
        Optional<Category> oldData = categoryRepo.findBycategoryName(name);
        try {
            if (oldData.isPresent()){
                Category updatedData = oldData.get();
                updatedData.setCategoryName(newData.getCategoryName());

                Category catData = categoryRepo.save(updatedData);

                String msg = "Data is Updated.";
                return new ResponseEntity<>(msg, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
