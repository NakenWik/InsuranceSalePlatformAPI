package com.nkdev.isp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductModel {

    @NotBlank
    @Schema(description = "Product code", example = "OD105")
    private String productCode;

    @NotBlank
    @Schema(description = "Product Name", example = "สุขใจวัยเกษียณ")
    private String productName;

    @NotNull
    @Schema(description = "Product type", example = "BASE")
    private String productType;

    @NotNull
    @Schema(description = "Sum Assure", example = "1000000.00")
    private BigDecimal sa;

    @NotNull
    @Schema(description = "premium", example = "20013.90")
    private BigDecimal premium;

}
