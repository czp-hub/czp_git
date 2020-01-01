package com.fh.utils;

public enum ServerEnum {

    ERROR(500,"失败"),
    SUCCESS(200,"成功");

    private Integer code;
    private String message;

    ServerEnum(Integer code, String message) {
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
