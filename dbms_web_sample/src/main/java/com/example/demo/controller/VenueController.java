package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class VenueController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Product> listAllProducts(@RequestParam(required = false, name = "userId") Long userId,
            @RequestParam(required = false, name = "keyword") String keyword) {
        if (keyword != null) {
            return productService.getProductByKeyword(keyword);
        } else if (userId != null) {
            return productService.getProductByUserId(userId);
        } else {
            return productService.getAllProducts();
        }
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        System.out.println(product.getUser().getId());
        User user = userService.getUserById(product.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + product.getUser().getId()));
        product.setUser(user);
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}