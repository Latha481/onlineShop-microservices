package com.onlineShop.microservices.productdatarest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICE_DETAILS")
@Data
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRICE_ID")
    private Integer id;

    @Size(max=4)
    @Column(name = "CURRENCY_TYPE")
    private String currency;

    @NotNull
    @Column(name = "CURRENCY_AMOUNT")
    private BigDecimal amount;

}
