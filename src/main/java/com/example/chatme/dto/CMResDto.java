package com.example.chatme.dto;

import lombok.Data;

@Data
public class CMResDto<T> {

    private int code;
    private String message;
    private T data;
}
