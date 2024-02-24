package com.onlineShop.microservices.categoryservice.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Categories {

    private Integer categoryId;

    private String categoryName;

    private List<Product> products;
}
