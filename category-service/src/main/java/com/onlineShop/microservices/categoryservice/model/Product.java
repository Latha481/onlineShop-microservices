package com.onlineShop.microservices.categoryservice.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Product {

    private Integer productId;

    @NotNull
    private String name;

    private String brand;

    private String description;

    private List <Attribute> attributes;

    private Price price;

    private Inventory inventoryDetails;

//    @JoinColumn(name = "PRODUCT_CATEGORY_ID",referencedColumnName = "CATEGORY_ID")
//    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Categories.class)
//    private Categories category;

}
