package com.nkdev.isp.service;

import com.nkdev.isp.model.Product;
import com.nkdev.isp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Iterable<Product> getAllProducts(){
        Iterable<Product> result =  productRepo.findAll();
        return result;
    }

    public Product insertProduct(Product product){
        return productRepo.save(product);
    }

}
