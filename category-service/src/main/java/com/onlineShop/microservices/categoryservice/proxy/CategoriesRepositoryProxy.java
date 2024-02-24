package com.onlineShop.microservices.categoryservice.proxy;

import com.onlineShop.microservices.categoryservice.model.Categories;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="product-data-rest", url="localhost:8089")
public interface CategoriesRepositoryProxy {

    //http://localhost:8089/product-data-rest/addProducts

    @PostMapping("/product-data-rest/addProducts")
    public ResponseEntity<List<Categories>> addProducts (@Valid @RequestBody List <Categories> categories);

}
