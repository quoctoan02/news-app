package com.example.mobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ResponseDto {
    private String message;

    private List<?> data;


    public ResponseDto(String message) {
        this.message = message;
    }
}
