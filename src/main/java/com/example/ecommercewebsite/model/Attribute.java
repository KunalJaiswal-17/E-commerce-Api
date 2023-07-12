package com.example.ecommercewebsite.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "Attribute_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attributeId;

    @Column(unique = true)
    private String property;
    private String value;

//    @ElementCollection
//    @CollectionTable(name = "Attribute_map", joinColumns = @JoinColumn(name = "attribute_id", referencedColumnName = "attributeId"))
//    @MapKeyColumn(name = "keys")
//    @Column(name = "values")
//    Map<String, String> values = new HashMap<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;
}
