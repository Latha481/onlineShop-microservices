package com.onlineShop.microservices.apiGateway;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test")
    public String testing(){
        return "Heyyyy";
    }
    @GetMapping("/verifying")
    public String testingAdmin(){
        return "Heyyyy Test";
    }
    @GetMapping("/checkingg")
    public String testingPostinh(){
        return "Heyyyy Admin";
    }

}
