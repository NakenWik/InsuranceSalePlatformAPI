package com.nkdev.isp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayoutInfoModel {

    @NotNull
    @Schema(description = "Payout type", example = "BANK_TRANSFER")
    private String payoutType;
    @Schema(description = "Bank code **Required if payout type is BANK_TRANSFER", example = "00001")
    private String bankCode;
    @Schema(description = "Bank branch code **Required if payout type is BANK_TRANSFER", example = "B00001")
    private String bankBranchCode;
    @Schema(description = "Bank account name **Required if payout type is BANK_TRANSFER", example = "Naken Wikaha")
    private String bankAccountName;
    @Schema(description = "Bank account number **Required if payout type is BANK_TRANSFER", example = "0112345678")
    private String bankAccountNumber;
}
