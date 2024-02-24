package com.onlineShop.microservices.productdatarest.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CATEGORIES")
@Data
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Size(min=2)
    @Column(name="CATEGORY_NAME")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Product.class,fetch = FetchType.LAZY )
    @JoinColumn(name = "CATEGORY_PRODUCT_ID",referencedColumnName = "CATEGORY_ID")
    private List<Product> products;
}
