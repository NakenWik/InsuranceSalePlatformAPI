package com.nkdev.isp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressModel {

//    @NotBlank
    @Schema(description = "Address No", example = "99/99")
    private String addressNo;
    @Schema(description = "Moo", example = "10")
    private String moo;
    @Schema(description = "Soi", example = "-")
    private String soi;
    @Schema(description = "Road", example = "Sukhumvit 41")
    private String road;

//    @NotBlank
    @Schema(description = "Building name", example = "lpn condo sukhumvit 41")
    private String buildingName;
    @Schema(description = "Company name", example = "KWI")
    private String companyName;

//    @NotBlank
    @Schema(description = "Province Code", example = "10")
    private String provinceCode;
//    @NotBlank
    @Schema(description = "Province Name", example = "กรุงเทพ ฯลฯ")
    private String provinceName;

//    @NotBlank
    @Schema(description = "District Code", example = "10")
    private String districtCode;
//    @NotBlank
    @Schema(description = "District Name", example = "สวนหลวง")
    private String districtName;
//    @NotBlank
    @Schema(description = "Sub-District Code", example = "10")
    private String subDistrictCode;
//    @NotBlank
    @Schema(description = "Sub District Name", example = "สวนหลวง")
    private String subDistrictName;

//    @NotBlank
    @Schema(description = "Postal Code", example = "12110")
    private String postalCode;

//    @NotNull
    @Schema(description = "Address type", example = "CURRENT|RESIDENTIAL|BUSINESS")
    private String addressType;

//    @NotBlank
    @Schema(description ="Dispatch Address",example = "Y")
    @Pattern(regexp = "Y|N")
    private String dispatchAddress;

}
