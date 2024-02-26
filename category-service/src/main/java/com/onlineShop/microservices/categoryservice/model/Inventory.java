package com.onlineShop.microservices.categoryservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Inventory {


    private Integer id;

    @NotNull
    private Integer total;

    @NotNull
    private Integer available;

    @NotNull
    private Integer reserved;

}
