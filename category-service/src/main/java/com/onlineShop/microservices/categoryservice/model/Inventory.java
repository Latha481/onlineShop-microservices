package com.onlineShop.microservices.categoryservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Inventory {


    private Integer id;


    private Integer total;


    private Integer available;

    private Integer reserved;

}
