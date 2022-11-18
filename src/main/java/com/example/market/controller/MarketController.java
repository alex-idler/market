package com.example.market.controller;

import com.example.market.models.Product;
import com.example.market.models.User;
import com.example.market.service.ProductServiceImp;
import com.example.market.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class MarketController {

    private final UserServiceImp userService;  //todo ===============================
    private final ProductServiceImp productService; //todo =============================
    @Autowired
    public MarketController(UserServiceImp userService, ProductServiceImp productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("index")
    public String index() {

//        return productService.findAll().stream().map(Product::getTitle).toList().toString();
        return userService.findAll().stream().map(User::getPurchases).toList().toString();
    }
}
