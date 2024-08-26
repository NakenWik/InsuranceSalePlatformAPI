package com.nkdev.isp.repo;

import com.nkdev.isp.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends ElasticsearchRepository<Product, Long> {

}
