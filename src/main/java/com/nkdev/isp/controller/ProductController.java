package com.nkdev.isp.controller;

import com.nkdev.isp.model.Product;
import com.nkdev.isp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping("/products")
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product addProducts(@RequestBody Product product){
        return productService.insertProduct(product);
    }

}
