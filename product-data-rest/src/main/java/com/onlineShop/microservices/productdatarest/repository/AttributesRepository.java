package com.onlineShop.microservices.productdatarest.repository;

import com.onlineShop.microservices.productdatarest.model.Attribute;
import com.onlineShop.microservices.productdatarest.model.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "attributes")
public interface AttributesRepository extends CrudRepository<Attribute,Integer> {

}
