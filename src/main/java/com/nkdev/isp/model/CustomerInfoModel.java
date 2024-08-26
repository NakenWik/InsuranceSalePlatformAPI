package com.nkdev.isp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfoModel {

//    @NotBlank
    @Schema(description = "Salutation Code", example = "T10")
    private String salutationCode;
//
//    @NotNull
//    @Schema(description = "Identity Type", example = "M")
//    private IdentityType identityType;

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
    @Schema(description = "Gender", example = "MALE")
    private String gender;
    @Schema(description = "Relation to Insured", example = "001")
    private String relationCode;
//    @NotBlank
    @Schema(description = "Occupation Code", example = "O01")
    private String occupationCode;
//    @NotBlank
    @Schema(description = "Marital Status", example = "O01")
    private String maritalStatus;
//    @NotBlank
    @Schema(description = "Phone number", example = "0839383938")
    private String phoneNumber;

    @Schema(description = "Other Phone number", example = "0839383938")
    private String otherPhoneNumber;

//    @NotBlank
    @Schema(description = "Email address", example = "example@mail.com")
    private String email;
//    @NotNull
    @Schema(description = "Client Type", example = "INSURED")
    private String clientType;

    @Valid
//    @NotNull
    @Schema(description = "Residential address")
    private AddressModel residentialAddress;

}
