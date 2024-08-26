package com.nkdev.isp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BeneficiaryModel {

//    @NotBlank
    @Schema(description = "Salutation Code", example = "T10")
    private String salutationCode;

//    @NotBlank
    @Schema(description = "Citizen Id", example = "1234567890123")
    private String citizenId;
//    @NotBlank
    @Schema(description = "FirstName Thai", example = "firstName")
    private String firstNameTh;
//    @NotBlank
    @Schema(description = "LastName Thai", example = "lastName")
    private String lastNameTh;

    @Schema(description = "FirstName Eng", example = "firstNameEng")
    private String firstNameEn;
    @Schema(description = "LastName Eng", example = "firstNameEng")
    private String lastNameEn;

//    @NotBlank
    @Schema(description = "Date of birth", example = "1999-01-02")
    private String dateOfBirth;
//    @NotBlank
    @Schema(description = "Country Code", example = "THA")
    private String countryCode;
//    @NotNull
    @Schema(description = "Gender", example = "MALE|FEMALE")
    private String gender;

    @Schema(description = "Relation to Insured", example = "1")
    private String relationship;
    @Schema(description = "Percentage", example = "100.00")
    private String percentage;

//    @Valid
//    @NotNull
    @Schema(description = "Residential address")
    private AddressModel residentialAddress;

}
