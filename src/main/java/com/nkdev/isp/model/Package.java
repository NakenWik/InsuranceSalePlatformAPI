package com.nkdev.isp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Package {

    private String packageCode;
    private String packageName;
    private String packageType; // Company Package / Customer customize package
    //    @NotNull
//    @Schema(description = "Selected Product list")
//    private List<ProductModel> productList;
}
