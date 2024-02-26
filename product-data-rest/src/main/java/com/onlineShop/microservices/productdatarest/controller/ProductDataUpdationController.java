package com.onlineShop.microservices.productdatarest.controller;


import com.onlineShop.microservices.productdatarest.customHandler.CustomResponseHandler;
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

@RestController
@RequestMapping(value="/admin")
public class ProductDataUpdationController {

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


    @PostMapping("/addProducts")
    public ResponseEntity <Object> addProducts (@Valid @RequestBody List <Categories> categories) throws Exception {
        try{
            categories.forEach(category -> categoriesRepository.save(category));
            return CustomResponseHandler.generateResponse(HttpStatus.CREATED, "Success", categories);

        }
        catch (Exception e){
            throw new ProductNotSavedException();
        }
    }

    @PostMapping("/addProductsToExistingCategory")
    public ResponseEntity<Object> addAdditionalProducts (@RequestBody Product product, @RequestParam String categoryName) throws Exception{

        try{
            Optional <Categories> categoryDetail = categoriesRepository.findByCategoryName(categoryName);
            if(categoryDetail.isPresent()){
                categoryDetail.get().getProducts().add(product);
                Categories savedCategory = categoriesRepository.save(categoryDetail.get());
                return CustomResponseHandler.generateResponse(HttpStatus.CREATED, "Success", savedCategory);
            }
            else{
                return CustomResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Success", "Product Not Found");
            }
        }
        catch (Exception e){
            throw new ProductNotSavedException();
        }
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<Object> deleteProducts(@RequestParam Integer productId) throws Exception{
        try{
            Optional<Product> productToDelete = productRepository.findById(productId);
            if(productToDelete.isPresent()){
                productRepository.deleteById(productId);
                return CustomResponseHandler.generateResponse(HttpStatus.OK, "Success", "Deleted Successfully");
            }
            else{
                return CustomResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Success", "Product Not Found");
            }
        }
        catch(Exception e)
        {
            throw new ProductNotFoundException();
        }
    }

    @PatchMapping("/updateProduct")
    public ResponseEntity<Object> updateProducts(@RequestBody Product patchProduct, @RequestParam Integer productId) {

        try {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()) {
            Product updatedProduct = categoryService.checkAndUpdatePatch(patchProduct, existingProduct.get());
            Product savedProduct = productRepository.save(updatedProduct);
            return CustomResponseHandler.generateResponse(HttpStatus.PARTIAL_CONTENT, "Success", savedProduct);
        } else {
            return CustomResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Success", "Product Not Found");
        }
    }
        catch(Exception e)
        {
            throw new ProductNotSavedException();
        }

    }

}
