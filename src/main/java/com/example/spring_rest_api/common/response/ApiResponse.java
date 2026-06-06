package com.example.spring_rest_api.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiResponse<T> {

    private final String message;
    private final T data;

    public static <T> ApiResponse<T> of(String message, T data) {
        return new ApiResponse<T>(message, data);
    }
}
