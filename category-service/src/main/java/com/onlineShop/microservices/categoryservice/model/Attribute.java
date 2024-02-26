package com.onlineShop.microservices.categoryservice.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attribute {
    private Integer id;

    @NotBlank
    private String attributeName;

    @NotBlank
    private String attributeValue;

}
