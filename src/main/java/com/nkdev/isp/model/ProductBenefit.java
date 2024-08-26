package com.nkdev.isp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//@Document(indexName = "product_benefit_index")
public class ProductBenefit {
    private long productId;
    private String productCode;
    private String productNameTh;
    private String productNameEn;
    private String productImage;
    private Iterable<BenefitDetail> benefitDetailList;
}
