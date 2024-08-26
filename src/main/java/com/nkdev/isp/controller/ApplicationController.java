package com.nkdev.isp.controller;

import com.amazonaws.Response;
import com.nkdev.isp.commons.base.IspApiResponse;
import com.nkdev.isp.model.ApplicationModel;
import com.nkdev.isp.model.Product;
import com.nkdev.isp.service.AmazonClientService;
import com.nkdev.isp.service.ApplicationService;
import com.nkdev.isp.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ApplicationController {

    @Autowired
    private final ApplicationService applicationService;
    @Autowired
    private final AmazonClientService amazonClientService;

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
    @GetMapping("/applications")
    public ResponseEntity<IspApiResponse<Iterable<ApplicationModel>>> getAllApplication(HttpServletRequest request){
        /*This code only mockup for testing : the production version should separate FE API and backend that some logic is only mock-up data.*/
        Iterable<ApplicationModel> applicationList = applicationService.getAllApplication();
        IspApiResponse<Iterable<ApplicationModel>> response = ResponseUtil.success(applicationList, "Application submit successfully", request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

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
    @GetMapping("/applications/{id}")
    public ResponseEntity<IspApiResponse<ApplicationModel>> getAllApplication(@PathVariable int id, HttpServletRequest request){
        /*This code only mockup for testing : the production version should separate FE API and backend that some logic is only mock-up data.*/
        ApplicationModel applicationModel = applicationService.getAllApplication().iterator().next();
        if (applicationModel == null) {
            throw new ResourceNotFoundException("Application not found with id " + id);
        }
        IspApiResponse<ApplicationModel> response = ResponseUtil.success(applicationModel, "Product fetched successfully", request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "For delete all application only for test and developer need to clear all application  ")
    @DeleteMapping("/applications")
    public ResponseEntity<HttpStatus> deleteAllApplication(){
        applicationService.deleteAllApplication();
        return ResponseEntity.ok(HttpStatus.OK);
    }

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
    @Operation(summary = "For submit application")
    @PostMapping("/applications")
    public ResponseEntity<IspApiResponse<ApplicationModel>>  applicationSubmit(@RequestBody ApplicationModel applicationModel, HttpServletRequest request){
        /*This code only mockup for testing : the production version should separate FE API and backend that some logic is only mock-up data.*/
        if (applicationModel.getProposalNo() == null) {
            applicationModel.setProposalNo(System.currentTimeMillis()); // mockup
        }
        ApplicationModel application = applicationService.submitApplication(applicationModel);
        if (applicationModel == null) {
            throw new ResourceNotFoundException("Application submit failed " );
        }
        IspApiResponse<ApplicationModel> response = ResponseUtil.success(application, "Application submit successfully", request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "E-KYC ID-Card upload")
    @PostMapping("/e-kyc/id-card")
    public ResponseEntity<HttpStatus> uploadIdCard(@RequestParam("file") MultipartFile file) throws Exception {
        /*This code only mockup for testing : the production version should separate FE API and backend that some logic is only mock-up data.*/
        log.info(file.getOriginalFilename());
        amazonClientService.uploadFile(file);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
