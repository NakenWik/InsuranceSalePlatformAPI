package com.nkdev.isp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "product_index")
public class Product {
    @Id
    private long productId;
    private String productCode;
    private String productName;
    private int sequence;
}

