package com.onlineShop.microservices.categoryservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attribute {
    private Integer id;

    private String attributeName;

    private String attributeValue;

}
