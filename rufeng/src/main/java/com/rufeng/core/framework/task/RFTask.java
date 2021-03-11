package com.rufeng.core.framework.task;

import com.rufeng.core.utils.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 *
 */
@Component("RHTask")
public class RFTask {
    public void rfMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void rfParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void rfNoParams() {
        System.out.println("执行无参方法");
    }
}
