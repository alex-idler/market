package com.example.market.controller;

import com.example.market.models.Product;
import com.example.market.models.Purchase;
import com.example.market.models.User;
import com.example.market.service.ProductService;
import com.example.market.service.PurchaseService;
import com.example.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MarketController {

    private final UserService userService;
    private final ProductService productService;
    private final PurchaseService purchaseService;
    @Autowired
    public MarketController(UserService userService, ProductService productService, PurchaseService purchaseService) {
        this.userService = userService;
        this.productService = productService;
        this.purchaseService = purchaseService;
    }

    @GetMapping("users")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @GetMapping("user")
    public List<User> findByLastname(@RequestParam("lastname") String lastname) {
        return userService.findByLastname(lastname);
    }

    @GetMapping("count")
    public List<User> findUsersByCountOfProducts(@RequestParam("product") String title, @RequestParam("value") Long value) {
        return userService.findUsersByCountOfProducts(title, value);
    }

    @GetMapping("sum")
    public List<User> findUsersBySumPrice(@RequestParam("min") Double minSum, @RequestParam("max") Double maxSum) {
        return userService.findUsersBySumPrice(minSum, maxSum);
    }

    @GetMapping("passive")
    public List<User> findPassiveUsers(@RequestParam("value") int value) {
        return userService.findPassiveUsers(value);
    }

    @GetMapping("products")
    public List<Product> findAllProducts() {
        return productService.findAll();
    }

    @GetMapping("purchases")
    public List<Purchase> findAllPurchases() {
        return purchaseService.findAll();
    }
}
