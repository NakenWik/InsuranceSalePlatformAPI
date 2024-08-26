package com.nkdev.isp.service;

import com.nkdev.isp.model.ProductCategory;
import com.nkdev.isp.repo.ProductCategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepo productCategoryRepo;

    public Iterable<ProductCategory>  productCategories() throws Exception{
        return productCategoryRepo.findAll();
    }

    public ProductCategory addProductCategory(ProductCategory productCategory) throws Exception {
        return productCategoryRepo.save(productCategory);
    }
}
