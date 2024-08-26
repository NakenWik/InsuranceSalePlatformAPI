package com.nkdev.isp.controller;

import com.nkdev.isp.commons.base.IspApiResponse;
import com.nkdev.isp.model.BenefitDetail;
import com.nkdev.isp.model.ProductBenefit;
import com.nkdev.isp.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ProductBenefitController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IspApiResponse.class))),
            @ApiResponse(responseCode = "1401", description = "Unauthorized",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IspApiResponse.class))),
            @ApiResponse(responseCode = "1403", description = "Forbidden",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IspApiResponse.class))),
            @ApiResponse(responseCode = "1404", description = "Not found",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IspApiResponse.class)))
    })
    @Operation(summary = "To get single application")
    @GetMapping("/product-benefit")
    public ResponseEntity<IspApiResponse<ProductBenefit>> getProductBenefit(HttpServletRequest request){
        /*This code only mockup for testing : the production version should separate FE API and backend that some logic is only mock-up data.*/
        ProductBenefit productBenefit = ProductBenefit.builder()
                .productId(1L)
                .productCode("EA0001")
                .productNameEn("Easy E-Save 10/5")
                .productNameTh("ประกันชีวิตแบบสะสมทรัพย์ระยะสั้น")
                .productImage("https://plus.unsplash.com/premium_photo-1661776260388-f5d1b14ce8a2?q=80&w=2832&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .benefitDetailList(List.of(
                        BenefitDetail.builder().benefitCode("B0001").benefitDescription("อยากมีเงินเก็บต้องวางแผนและเริ่มต้นตั้งแต่วันนี้").Order(1).build(),
                        BenefitDetail.builder().benefitCode("B0002").benefitDescription("ซื้อประกันสะสมทรัพย์ Easy E-Save 10/5").Order(2).build(),
                        BenefitDetail.builder().benefitCode("B0003").benefitDescription("รับผลตอบแทนแน่นอน การันตีเงินคืนทุกปี").Order(3).build(),
                        BenefitDetail.builder().benefitCode("B0004").benefitDescription("ผลตอบแทนรวม 350% ของทุนประกัน").Order(4).build(),
                        BenefitDetail.builder().benefitCode("B0005").benefitDescription("การันตีเงินคืนทุกปีสูงสุด 5% ของทุนประกัน").Order(5).build(),
                        BenefitDetail.builder().benefitCode("B0006").benefitDescription("ชำระเบี้ยฯสั้น เท่ากันทุกปีเพียง 5 ปี").Order(6).build(),
                        BenefitDetail.builder().benefitCode("B0007").benefitDescription("ลดหย่อนภาษีได้สูงสุด 100,000 บาท").Order(7).build()
                ))
                .build();
        IspApiResponse<ProductBenefit> response = ResponseUtil.success(productBenefit, "Application submit successfully", request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
