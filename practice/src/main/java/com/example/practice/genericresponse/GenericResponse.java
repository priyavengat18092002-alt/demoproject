package com.example.practice.genericresponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponse<T> {
    private boolean success;
    private T data;
    private String message;

    public static <T> GenericResponse<T> success(T data, String message) {
        return new GenericResponse<>(true, data, message);
    }
    public static <T> GenericResponse<T> error(T data, String message) {
        return new GenericResponse<>(false, data, message);
    }
    public static <T> GenericResponse<T> error(String message) {
        return new GenericResponse<>(false, null, message);
    }
}
