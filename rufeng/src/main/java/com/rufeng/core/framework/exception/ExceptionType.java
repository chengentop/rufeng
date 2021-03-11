package com.rufeng.core.framework.exception;

import com.rufeng.core.framework.common.constant.Constants;

public enum ExceptionType {
    DB_ACCESS_EXCEPTION        			(Constants.DA_ERROR_CODE, "数据库访问异常"),


    ;

    private int code;
    private String mess;

    ExceptionType(int code, String mess) {
        this.code = code;
        this.mess = mess;
    }

    public int getCode() {
        return code;
    }

    public String getMess() {
        return mess;
    }
}
