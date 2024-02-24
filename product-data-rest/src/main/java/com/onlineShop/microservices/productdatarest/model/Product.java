package com.onlineShop.microservices.productdatarest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @NotNull
    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_BRAND")
    private String brand;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Attribute.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ATTRIBUTE_ID",referencedColumnName = "PRODUCT_ID")
    private List <Attribute> attributes;

    @JoinColumn(name = "PRODUCT_PRICE_ID", referencedColumnName = "PRICE_ID")
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Price.class)
    private Price price;

    @JoinColumn(name = "PRODUCT__INVENTORY_ID", referencedColumnName = "INVENTORY_ID")
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Inventory.class)
    private Inventory inventoryDetails;

//    @JoinColumn(name = "PRODUCT_CATEGORY_ID",referencedColumnName = "CATEGORY_ID")
//    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Categories.class)
//    private Categories category;

}
