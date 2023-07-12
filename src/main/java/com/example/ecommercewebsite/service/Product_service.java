package com.example.ecommercewebsite.service;

import com.example.ecommercewebsite.model.Category;
import com.example.ecommercewebsite.model.Product;
import com.example.ecommercewebsite.model.SubCategory;
import com.example.ecommercewebsite.repository.Product_Repo;
import com.example.ecommercewebsite.repository.SubCategory_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Product_service {
    @Autowired
    private SubCategory_Repo subCategoryRepo;

    @Autowired
    private Product_Repo productRepo;


    public Object createProductByName(Product product, String name){
        Optional<SubCategory> data = subCategoryRepo.findBysubCategoryName(name);
        SubCategory subCategory = data.get();
        product.setSubCategory(subCategory);
        Product productData = productRepo.save(product);
        try{
            String message = "Product Created\n";
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Product> getProductById(Long id){
        Optional<Product> productObj = productRepo.findById(id);
        try{
            if(productObj.isPresent()){
                return new ResponseEntity<>(productObj.get(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Product>> getAllProduct(){
        try{
            List<Product> products = new ArrayList<>();
            productRepo.findAll().forEach(products::add);

            if(products.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Object updateProductById(Long id, Product newData){
        Optional<Product> oldData = productRepo.findById(id);
        try {
            if (oldData.isPresent()){
                Product updatedData = oldData.get();
                updatedData.setName(newData.getName());
                updatedData.setPrice(newData.getPrice());
                updatedData.setDescription(newData.getDescription());
                Product catData = productRepo.save(updatedData);

                String msg = "Data is Updated.";
                return new ResponseEntity<>(msg, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Product> deleteProductById(Long id){
        try {
            Optional<Product> productId = productRepo.findById(id);
            if (productId.isPresent()) {
                productRepo.delete(productId.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
