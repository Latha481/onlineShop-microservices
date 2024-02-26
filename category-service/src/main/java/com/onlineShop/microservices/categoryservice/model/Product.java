package com.onlineShop.microservices.categoryservice.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class Product {

    private Integer productId;

    @NotBlank
    private String name;

    @NotBlank
    private String brand;

    @NotBlank
    private String description;

    @NotEmpty(message = "Attributes shouldnt be empty.")
    private List <@Valid Attribute> attributes;

    @Valid
    @NotNull
    private Price price;

    private Inventory inventoryDetails;

}
