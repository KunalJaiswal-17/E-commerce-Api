package com.example.ecommercewebsite.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SubCategory_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subCategoryId;
    private String subCategoryName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    @JsonManagedReference
//    @JoinColumn(name = "subCategoryId")
    private List<Product> products = new ArrayList<>();
}
