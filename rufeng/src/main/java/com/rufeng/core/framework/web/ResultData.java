package com.rufeng.core.framework.web;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

import com.rufeng.core.framework.common.constant.Constants;
import com.rufeng.core.utils.DateUtils;

public class ResultData implements Serializable, IDataReturnAble {
    private static final long serialVersionUID = 8051392644227606172L;

    public static final String CPDE = "code";
    public static final String MSG = "msg";
    public static final String TIME = "time";

    private int code; //返回码
    private String msg; //返回描述
    private String time;//服务器响应时间
    private Map<String, Object> data = new HashMap<String, Object>(); //返回数据，如果返回异常则为空Map

    /**
     * 推荐使用初始化方法构造结果
     *
     * @return
     */
    public static ResultData init() {
        return new ResultData(Constants.SUCCESS_CODE, Constants.SUCCESS_REASON, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public ResultData(int code) {
        this(code, Constants.SUCCESS_REASON, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public ResultData(int code, String msg) {
        this(code, msg, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public ResultData(int code, String msg, String time) {
        this.setCode(code);
        this.setMsg(msg);
        this.setTime(time);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{code=").append(code).append(", msg=").append(msg).append(", time=").append(DateUtils.parseDate(time)).append("}");
        return sb.toString();
    }

    public enum ResType {
        DATA,
        EXCEPTION,
        ;
    }

    public void setData(Map<String, Object> data) {
        this.data.putAll(data);
    }

    public void setData(String key, Object value) {
        this.data.put(key, value);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
