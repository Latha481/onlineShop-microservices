package com.onlineShop.microservices.categoryservice.controller;


import com.onlineShop.microservices.categoryservice.model.Categories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesController {

    @GetMapping("/getAllCategories")
    public Categories retrieveCategories(){

        return new Categories(1,"Electronics");
    }
}
