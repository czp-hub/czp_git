package com.fh.utils.response;

/**
 * @author shangfeng
 * @Title: ResponseServer
 * @Package com.fh.commons.response
 * @Description: ${todo}
 * @date 2019/7/2  10:43
 */
public class ResponseServer {

    private Integer code;

    private String message;

    private Object data;


    private ResponseServer(){

    }
    private ResponseServer(Integer code,String message){
        this.code=code;
        this.message=message;

    }
    private ResponseServer(Integer code,String message,Object data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

    /**
     * 返回默认的 成功状态 200
     * @return
     */
    public static ResponseServer success(){
        return new ResponseServer(ServerEnum.SUCCESS.getCode(), ServerEnum.SUCCESS.getMessage());
    }

    /**
     * 返回默认的带数据 成功状态 200
     * @param data
     * @return
     */
    public static ResponseServer success(Object data){
        return new ResponseServer(ServerEnum.SUCCESS.getCode(), ServerEnum.SUCCESS.getMessage(),data);
    }

    /**
     * 其他特殊类型的成功状态，
     * @param serverEnum
     * @return
     */
    public static ResponseServer success(ServerEnum serverEnum){
        return new ResponseServer(serverEnum.getCode(),serverEnum.getMessage());
    }

    /**
     * 带返回数据的其他特殊类型的成功状态
     * @param serverEnum
     * @param data
     * @return
     */
    public static ResponseServer success(ServerEnum serverEnum, Object data){
        return new ResponseServer(serverEnum.getCode(),serverEnum.getMessage(),data);
    }


///////失败
        public static ResponseServer error(Integer code, String message){
            return new ResponseServer(code,message);
        }
    /**
+     * @return
     */
    public static ResponseServer error(){
        return new ResponseServer(ServerEnum.ERROR.getCode(), ServerEnum.ERROR.getMessage());
    }

    /**
     * 返回默认的带数据 失败状态 500
     * @param data
     * @return
     */
    public static ResponseServer error(Object data){
        return new ResponseServer(ServerEnum.ERROR.getCode(), ServerEnum.ERROR.getMessage(),data);
    }

    /**
     * 其他特殊类型的失败状态，
     * @param serverEnum
     * @return
     */
    public static ResponseServer error(ServerEnum serverEnum){
        return new ResponseServer(serverEnum.getCode(),serverEnum.getMessage());
    }

    /**
     * 带返回数据的其他特殊类型的失败状态
     * @param serverEnum
     * @param data
     * @return
     */
    public static ResponseServer error(ServerEnum serverEnum, Object data){
        return new ResponseServer(serverEnum.getCode(),serverEnum.getMessage(),data);
    }

    public Integer getCode() {
        return code;
    }

    public String getmessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
