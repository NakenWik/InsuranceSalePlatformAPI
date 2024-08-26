package com.nkdev.isp.commons.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IspApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private List<String> errors;
    private int errorCode;
    private long timestamp;  // Adding timestamp for tracking
    private String path;     // Adding path to identify the API endpoint

    // Constructors, getters, and setters
}