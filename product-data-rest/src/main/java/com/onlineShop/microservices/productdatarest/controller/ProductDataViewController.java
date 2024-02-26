package com.onlineShop.microservices.productdatarest.controller;


import com.onlineShop.microservices.productdatarest.customHandler.CustomResponseHandler;
import com.onlineShop.microservices.productdatarest.exception.CategoryNotFoundException;
import com.onlineShop.microservices.productdatarest.exception.ProductNotFoundException;
import com.onlineShop.microservices.productdatarest.exception.ProductNotSavedException;
import com.onlineShop.microservices.productdatarest.model.Categories;
import com.onlineShop.microservices.productdatarest.model.Product;
import com.onlineShop.microservices.productdatarest.repository.CategoriesRepository;
import com.onlineShop.microservices.productdatarest.repository.InventoryRepository;
import com.onlineShop.microservices.productdatarest.repository.PriceRepository;
import com.onlineShop.microservices.productdatarest.repository.ProductRepository;
import com.onlineShop.microservices.productdatarest.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/user")
public class ProductDataViewController {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/getAllProductsForCategory/{categoryName}")
    public ResponseEntity<Object> retrieveAllProductsForCategory(@PathVariable String categoryName) throws Exception{
        try{
            Optional<Categories> categoryDetail = categoriesRepository.findByCategoryName(categoryName);
            return categoryDetail.map(categories -> CustomResponseHandler.generateResponse(HttpStatus.OK, "Success", categories.getProducts())).orElseGet(() -> CustomResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Success", "Category Not Found"));
        }
        catch (Exception e){
            throw new CategoryNotFoundException();
        }
    }

    @GetMapping("/getAllProductsForInventoryCountOrPriceValue/{categoryName}")
    public ResponseEntity<Object> retrieveProductsForCategoryAndInventoryCountOrPrice(@PathVariable String categoryName,
                                                                             @RequestParam Integer inventoryCount ,
                                                                             @RequestParam Double priceValue) throws Exception{
        try{
            Optional<Categories> categoryDetail = categoriesRepository.findByCategoryName(categoryName);

if(categoryDetail.isPresent()){
    List<Product> products = categoryDetail.get().getProducts().stream()
            .filter(product -> categoryService.checkIfProductToBeAdded(priceValue, product.getPrice().getAmount()))
            .filter(product -> categoryService.checkIfProductToBeAdded(inventoryCount, product.getInventoryDetails().getAvailable()))
            .collect(Collectors.toList());
    if(products.size()>0){
        return  CustomResponseHandler.generateResponse(HttpStatus.OK, "Success", products);
    }
    else{
        return  CustomResponseHandler.generateResponse(HttpStatus.OK, "Success", "Products for requested filters not found");
    }
}
else{
    return  CustomResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Success", "Category not found");
}
        }
        catch (Exception e) {
            throw new ProductNotFoundException();
        }

    }

}
