package com.onlineShop.microservices.productdatarest.controller;

import com.onlineShop.microservices.productdatarest.customHandler.CustomResponseHandler;
import com.onlineShop.microservices.productdatarest.exception.ProductNotSavedException;
import com.onlineShop.microservices.productdatarest.model.*;
import com.onlineShop.microservices.productdatarest.repository.CategoriesRepository;
import com.onlineShop.microservices.productdatarest.service.CategoryService;
import jakarta.validation.Valid;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductDataUpdationControllerTest {

    @Mock
    CategoriesRepository categoriesRepository;

    @InjectMocks
    CategoryService categoryService;

    @BeforeEach
    public void setup(){
        
        Attribute attribute1 = Attribute.builder()
                .attributeName("Color")
                .attributeValue("Silver")
                .build();
        Product product = Product.builder()
                .price(Price.builder().amount(100.0).currency("INR").build())
                .inventoryDetails(Inventory.builder().available(90).reserved(10).total(100).build())
                .attributes(List.of(attribute1))
                .brand("Reliance")
                .name("Dress")
                .description("Winter wear")
                .build();

        Categories categories = Categories.builder()
                .categoryName("Clothes")
                .products(List.of(product))
                .build();

    }

    @Test
    void addProducts() {




//        @PostMapping("/addProducts")
//        public ResponseEntity<Object> addProducts (@Valid @RequestBody List < Categories > categories) throws Exception {
//            try{
//                categories.forEach(category -> categoriesRepository.save(category));
//                return CustomResponseHandler.generateResponse(HttpStatus.CREATED, "Success", categories);
//
//            }
//            catch (Exception e){
//                throw new ProductNotSavedException();
//            }
//        }


    }

    @Test
    void addAdditionalProducts() {
    }

    @Test
    void deleteProducts() {
    }

    @Test
    void updateProducts() {
    }
}