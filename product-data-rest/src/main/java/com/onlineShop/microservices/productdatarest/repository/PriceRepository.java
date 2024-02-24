package com.onlineShop.microservices.productdatarest.repository;

import com.onlineShop.microservices.productdatarest.model.Categories;
import com.onlineShop.microservices.productdatarest.model.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "priceDetails")
public interface PriceRepository extends CrudRepository<Price,Integer> {

}
