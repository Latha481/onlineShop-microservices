package com.onlineShop.microservices.productdatarest.repository;

import com.onlineShop.microservices.productdatarest.model.Categories;
import com.onlineShop.microservices.productdatarest.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "products")
public interface ProductRepository extends CrudRepository<Product,Integer> {

}
