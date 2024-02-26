package com.onlineShop.microservices.categoryservice.model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Categories {

    private Integer categoryId;

    @NotNull
    private String categoryName;
    @NotEmpty
    private List<@Valid Product> products;
}
