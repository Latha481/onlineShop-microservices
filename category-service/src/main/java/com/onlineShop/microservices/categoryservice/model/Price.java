package com.onlineShop.microservices.categoryservice.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Price {

    private Integer id;

    @Size(max=4)
    private String currency;

    @NotNull
    private BigDecimal amount;

}
