package com.example.lab1.dto;

public class ResponseInfo {
    private Boolean success = true;
    private String message = "";

    public ResponseInfo() {}

    public ResponseInfo(boolean success) {
        this.success = success;
    }

    public ResponseInfo(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
