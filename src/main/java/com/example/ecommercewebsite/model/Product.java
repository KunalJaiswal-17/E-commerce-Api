package com.example.ecommercewebsite.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;
    private String description;
    private Float price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "subCategoryId")
    private SubCategory subCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
//    @JoinColumn(name = "productId")
    private List<Attribute> attributes = new ArrayList<>();
}
