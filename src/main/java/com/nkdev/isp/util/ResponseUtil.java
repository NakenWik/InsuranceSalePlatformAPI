package com.nkdev.isp.util;

import com.nkdev.isp.commons.base.IspApiResponse;

import java.util.Arrays;
import java.util.List;

public class ResponseUtil {

    public static <T> IspApiResponse<T> success(T data, String message, String path) {
        IspApiResponse<T> response = new IspApiResponse<>();
        response.setSuccess(true);
        response.setMessage(message);
        response.setData(data);
        response.setErrors(null);
        response.setErrorCode(0); // No error
        response.setTimestamp(System.currentTimeMillis());
        response.setPath(path);
        return response;
    }

    public static <T> IspApiResponse<T> error(List<String> errors, String message, int errorCode, String path) {
        IspApiResponse<T> response = new IspApiResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        response.setData(null);
        response.setErrors(errors);
        response.setErrorCode(errorCode);
        response.setTimestamp(System.currentTimeMillis());
        response.setPath(path);
        return response;
    }

    public static <T> IspApiResponse<T> error(String error, String message, int errorCode, String path) {
        return error(Arrays.asList(error), message, errorCode, path);
    }
}