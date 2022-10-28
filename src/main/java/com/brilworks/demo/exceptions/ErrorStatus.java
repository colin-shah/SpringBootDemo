package com.brilworks.demo.exceptions;

public class ErrorStatus {
    private Integer code;
    private String message;

    public ErrorStatus() {
    }

    public ErrorStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
