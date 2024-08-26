package com.nkdev.isp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.OffsetDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "application_index")
public class ApplicationModel {

//    @NotBlank
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Schema(description = "Application Id")
    private String applicationId;

//    @NotBlank
    @Schema(description = "Proposal Number", example = "12313414")
    private Long proposalNo;

//    @NotNull
    @Schema( description = "Apply date", example = "2023-07-27T10:37:05.434+0000" )
    private OffsetDateTime applyDate;

//    @NotNull
    @Schema(description = "Deliver type", example = "E-POLICY")
    private String deliverType;

//    @NotNull
    @Schema(description = "Source channel type", example = "ONLINE")
    private String sourceChannel;

//    @NotNull
    @Schema(description = "Agent code", example = "HOD0001|AG0001")
    private String agentCode;

//    @NotNull
    @Schema(description = "policyStatus", example = "Initail|Application Submited|Underwriting|Inforce|Terminated")
    private String policyStatus;
//    @NotNull
//    @Schema(description = "Package code", example = "C00001")// Customer custom package
//    private String packageCode;

//    @NotNull
    @Schema(description = "Selected Product list")
    private List<ProductModel> productList;

    @Valid
    @NotNull
    @Schema(description = "insureInfo", example = "")
    private CustomerInfoModel insureInfo;

//    @Valid
//    @NotNull
//    @Schema(description = "Payout information")
//    private PayoutInfoModel payoutInfo;

//    @Valid
//    @NotNull
//    @Schema(description = "Beneficiary list")
//    private List<CustomerInfoModel> beneficiaryList;

//    @Valid
//    @NotNull
//    @Schema(description = "Alternate address list")
//    private List<AddressModel> alternateAddressList;

//    @Valid
//    @NotNull
//    @Schema(description = "Payment information")
//    private ApplicationPaymentInformationModel paymentInfo;
//
//    @Valid
//    @NotNull
//    @Schema(description = "Payment transaction list")
//    private List<ApplicationPaymentTransactionModel> paymentTransactionList;

}
