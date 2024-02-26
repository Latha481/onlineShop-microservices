package com.onlineShop.microservices.apiGateway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/admin/test")
    public String testing(){
        return "Heyyyy";
    }
    @GetMapping("/admin/verifying")
    public String testingAdmin(){
        return "Heyyyy Test";
    }
    @GetMapping("/user/checkingg")
    public String testingPostinh(){
        return "Heyyyy Not Admin";
    }

}
