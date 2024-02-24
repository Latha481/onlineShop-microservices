package com.onlineShop.microservices.productdatarest.controller;


import com.onlineShop.microservices.productdatarest.exception.CategoryNotFoundException;
import com.onlineShop.microservices.productdatarest.exception.ProductNotFoundException;
import com.onlineShop.microservices.productdatarest.exception.ProductNotSavedException;
import com.onlineShop.microservices.productdatarest.model.Categories;
import com.onlineShop.microservices.productdatarest.model.Product;
import com.onlineShop.microservices.productdatarest.repository.CategoriesRepository;
import com.onlineShop.microservices.productdatarest.repository.InventoryRepository;
import com.onlineShop.microservices.productdatarest.repository.PriceRepository;
import com.onlineShop.microservices.productdatarest.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/product-data-rest")
public class CategoriesController {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/addProducts")
    public ResponseEntity <List<Categories>> addProducts (@Valid @RequestBody List <Categories> categories) throws Exception {
        try{
            categories.forEach(category -> categoriesRepository.save(category));
            return ResponseEntity.status(HttpStatus.CREATED).body(categories);

        }
        catch (Exception e){
            throw new ProductNotSavedException();
        }
    }

    @PostMapping("/addProductsToExistingCategory")
    public ResponseEntity<Product> addAdditionalProducts (@RequestBody Product product, @RequestParam String categoryName) throws Exception{

        try{
            Categories categoryDetail = categoriesRepository.findByCategoryName(categoryName);
            categoryDetail.getProducts().add(product);
            categoriesRepository.save(categoryDetail);
            return ResponseEntity.created(null).build();
        }
        catch (Exception e){ //in case invalid product object
            throw new ProductNotSavedException();
        }
    }

    @GetMapping("/getAllProductsForCategory/{categoryName}")
    public List<Product> retrieveAllProductsForCategory(@PathVariable String categoryName) throws Exception{
        try{
    Categories categoryDetail = categoriesRepository.findByCategoryName(categoryName);

    return categoryDetail.getProducts();
        }
        catch (Exception e){
            throw new CategoryNotFoundException();
        }
    }

    @GetMapping("/getAllProductsForInventoryCountOrPriceValue/{categoryName}")
    public List<Product> retrieveProductsForCategoryAndInventoryCountOrPrice(@PathVariable String categoryName,
                                                                      @RequestParam Integer inventoryCount ,
                                                                      @RequestParam BigDecimal priceValue) throws Exception{
        try{
            Categories categoryDetail = categoriesRepository.findByCategoryName(categoryName);

            List<Product> allProducts =  categoryDetail.getProducts();

            return   categoryDetail.getProducts().stream()
                    .filter(product -> checkIfProductToBeAdded(priceValue,product.getPrice().getAmount()))
                    .filter(product -> checkIfProductToBeAdded(inventoryCount,product.getInventoryDetails().getAvailable()))
                    .collect(Collectors.toList());
        }
        catch (Exception e) {
            throw new ProductNotFoundException();
        }

    }

    public Boolean checkIfProductToBeAdded(BigDecimal value , BigDecimal productValue){
        return (value == null) || productValue.compareTo(value) >= 0;
    }

    public Boolean checkIfProductToBeAdded(Integer value , Integer productValue){
        return (value == null) || value < productValue || value.equals(productValue);
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProducts(@RequestParam Integer productId) throws Exception{
        try{
            productRepository.deleteById(productId);
        }
        catch(Exception e)
        {
            throw new ProductNotFoundException();
        }
    }

//    @PatchMapping("/updateProduct")
//    public  String updateProducts(@RequestBody Product product, @PathVariable Integer productId){
//
//        Optional<Product> existingProduct = productRepository.findById(productId);
//        existingProduct.get().
//
//
//
//        productRepository.save(existingProduct);
//
//        Optional<Categories> a = categoriesRepository.findById(product.getCategory().getCategoryId());
//
//        return "done";
//    }


}
