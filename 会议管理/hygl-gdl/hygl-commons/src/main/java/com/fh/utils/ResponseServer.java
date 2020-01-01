package com.fh.utils;

public class ResponseServer {

    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public ResponseServer(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseServer(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseServer error(Integer code, String message){
        return new ResponseServer(code,message);
    }


    public static ResponseServer error(ServerEnum serverEnum){
        return new ResponseServer(serverEnum.getCode(),serverEnum.getMessage());
    }

    public static ResponseServer success(){
        return new ResponseServer(ServerEnum.SUCCESS.getCode(), ServerEnum.SUCCESS.getMessage());
    }

    public static ResponseServer success(Object data){
        return new ResponseServer(ServerEnum.SUCCESS.getCode(), ServerEnum.SUCCESS.getMessage(),data);
    }

}
