package com.onlineShop.microservices.categoryservice.controller;

import ch.qos.logback.core.util.DefaultInvocationGate;
import com.onlineShop.microservices.categoryservice.model.Categories;
import com.onlineShop.microservices.categoryservice.model.Inventory;
import com.onlineShop.microservices.categoryservice.model.Price;
import com.onlineShop.microservices.categoryservice.model.Product;
import com.onlineShop.microservices.categoryservice.proxy.ProductServiceProxy;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CategoriesController {

    @Autowired
    private ProductServiceProxy productServiceProxy;

    private final Logger logger = LoggerFactory.getLogger(CategoriesController.class);

    @PostMapping("/addProducts")
    public ResponseEntity<Object> addProductsAndCategories(@Valid @RequestBody List<Categories> categories) {
        logger.info("Executing addProductsAndCategories api");
        return productServiceProxy.addProducts(categories);
    }

    @PostMapping("/addProductsToExistingCategory")
    public ResponseEntity<Object> addAdditionalProducts(@RequestBody Product product, @RequestParam String categoryName) {

        logger.info("Executing addAdditionalProducts api");

        return productServiceProxy.addProductsToExistingCategory(product, categoryName);

    }

    @GetMapping("/getAllProductsForCategory/{categoryName}")
    @Retry(name = "gettingProducts", fallbackMethod = "serviceUnavailable")
    public ResponseEntity<Object> retrieveAllProductsForCategory(@PathVariable String categoryName) {

        logger.info("Executing retrieveAllProductsForCategory api");
        return productServiceProxy.retrieveAllProductsForCategory(categoryName);
    }

    @GetMapping("/getAllProductsForInventoryCountOrPriceValue/{categoryName}")
    public ResponseEntity<Object> retrieveProductsForCategoryAndInventoryCountOrPrice(@PathVariable String categoryName,
                                                                             @RequestParam Integer inventoryCount,
                                                                             @RequestParam Double priceValue) {

        logger.info("Executing retrieveProductsForCategoryAndInventoryCountOrPrice api");
        return productServiceProxy.retrieveProductsForCategoryAndInventoryCountOrPrice(categoryName, inventoryCount, priceValue);

    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<Object> deleteProducts(@RequestParam Integer productId) {
        logger.info("Executing deleteProducts api");
        return productServiceProxy.deleteProducts(productId);

    }

    @PatchMapping("/updateProduct")
    public ResponseEntity<Object> updateProducts(@RequestBody Product product, @PathVariable Integer productId) {
        logger.info("Executing updateProducts api");
        return productServiceProxy.updateProducts(product, productId);
    }

    public ResponseEntity<Object> serviceUnavailable(Exception ex) {
    Product p = Product.builder()
            .price(Price.builder().amount(Double.NaN).build())
            .inventoryDetails(Inventory.builder().available(0).reserved(0).total(0).build())
            .build();
        return new ResponseEntity<Object>(p, HttpStatus.SERVICE_UNAVAILABLE);
    }


}
