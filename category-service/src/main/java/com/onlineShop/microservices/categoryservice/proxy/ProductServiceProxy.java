package com.onlineShop.microservices.categoryservice.proxy;

import com.onlineShop.microservices.categoryservice.model.Categories;
import com.onlineShop.microservices.categoryservice.model.Product;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name="product-data-rest")
public interface ProductServiceProxy {

    @PostMapping("/admin/addProducts")
    ResponseEntity<Object> addProducts (@Valid @RequestBody List <Categories> categories);

    @PostMapping("/admin/addProductsToExistingCategory")
    ResponseEntity<Object> addProductsToExistingCategory(@RequestBody Product product, @RequestParam String categoryName);

    @GetMapping("/user/getAllProductsForCategory/{categoryName}")
    ResponseEntity<Object> retrieveAllProductsForCategory(@PathVariable String categoryName);

    @GetMapping("/user/getAllProductsForInventoryCountOrPriceValue/{categoryName}")
    ResponseEntity<Object> retrieveProductsForCategoryAndInventoryCountOrPrice(@PathVariable String categoryName,
                                                                             @RequestParam Integer inventoryCount ,
                                                                             @RequestParam Double priceValue);
    @DeleteMapping("/admin/deleteProduct")
    ResponseEntity<Object> deleteProducts(@RequestParam Integer productId);

    @PatchMapping("/admin/updateProduct")
    ResponseEntity<Object> updateProducts(@RequestBody Product patchProduct, @RequestParam Integer productId);

    }
