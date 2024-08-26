package com.nkdev.isp.repo;

import com.nkdev.isp.model.ProductCategory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepo extends ElasticsearchRepository<ProductCategory, Long> {
}
