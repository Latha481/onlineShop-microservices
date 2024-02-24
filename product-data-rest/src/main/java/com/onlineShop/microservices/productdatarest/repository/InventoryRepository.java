package com.onlineShop.microservices.productdatarest.repository;

import com.onlineShop.microservices.productdatarest.model.Categories;
import com.onlineShop.microservices.productdatarest.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "inventoryDetails")
public interface InventoryRepository extends CrudRepository<Inventory,Integer> {

}
