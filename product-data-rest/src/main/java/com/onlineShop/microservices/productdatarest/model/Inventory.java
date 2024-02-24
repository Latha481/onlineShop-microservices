package com.onlineShop.microservices.productdatarest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INVENTORY_DETAILS")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INVENTORY_ID")
    private Integer id;

    @Column(name = "TOTAL_COUNT")
    private Integer total;

    @NotNull
    @Column(name = "AVAILABLE_COUNT")
    private Integer available;

    @Column(name = "RESERVED_COUNT")
    private Integer reserved;

}
