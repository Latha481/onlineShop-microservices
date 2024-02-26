package com.onlineShop.microservices.categoryservice.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {

    private Integer id;

    @Size(max=4)
    private String currency;

    @NotNull
    private Double amount;

}
