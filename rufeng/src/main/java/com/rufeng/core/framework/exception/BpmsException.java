package com.rufeng.core.framework.exception;


import com.rufeng.core.framework.common.constant.Constants;

public class BpmsException extends Exception {
    private static final long serialVersionUID = -7996942332801650268L;

    private int code;
    private String reason;

    public BpmsException(){
        super("错误");
        this.code = Constants.DEFAULT_ERROR_CODE;
        this.reason = "未知异常！";
    }

    public BpmsException(ExceptionType type){
        super("错误");
        this.code = type.getCode();
        this.reason = type.getMess();
    }

    public BpmsException(int code, String reason){
        this.code = code;
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

}
