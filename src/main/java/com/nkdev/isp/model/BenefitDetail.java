package com.nkdev.isp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//@Document(indexName = "product_benefit_detail_index")
public class BenefitDetail {
    private String benefitCode;
    private String benefitDescription;
    private int Order;
}
