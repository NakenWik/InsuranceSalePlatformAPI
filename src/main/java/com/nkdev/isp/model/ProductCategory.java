package com.nkdev.isp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "product_category_index")
public class ProductCategory {

    private long id;
    private String productCategoryCode;
    private String productCategoryName;

}
