package com.rufeng.core.framework.manager.factory;

import com.rufeng.business.system.domain.po.SysLogininfor;
import com.rufeng.business.system.domain.po.SysOperLog;
import com.rufeng.core.framework.common.constant.Constants;
import com.rufeng.core.utils.LogUtils;
import com.rufeng.core.utils.ServletUtils;
import com.rufeng.core.utils.ip.AddressUtils;
import com.rufeng.core.utils.ip.IpUtils;
import com.rufeng.core.utils.spring.SpringUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @author ruoyi
 */
public class AsyncFactory {
    private static final Logger sysuserlogger = LoggerFactory.getLogger("sys-user");

    /**
     * 记录登陆信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息
     * @param args     列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(final String username, final String status, final String message,
                                             final Object... args) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        return new TimerTask() {
            @Override
            public void run() {
                String address = AddressUtils.getRealAddressByIP(ip);
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                sysuserlogger.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                SysLogininfor logininfor = new SysLogininfor();
                logininfor.setUsername(username);
                logininfor.setIpaddr(ip);
                logininfor.setLoginlocation(address);
                logininfor.setBrowser(browser);
                logininfor.setOs(os);
                logininfor.setMsg(message);
                // 日志状态
                if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
                    logininfor.setStatus(Constants.SUCCESS);
                } else if (Constants.LOGIN_FAIL.equals(status)) {
                    logininfor.setStatus(Constants.FAIL);
                }
                // 插入数据
                try {
                    SpringUtils.getBean(com.rufeng.business.system.service.ISysLogininforService.class).add(logininfor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /**
     * 操作日志记录
     *
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final SysOperLog operLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                operLog.setOperlocation(AddressUtils.getRealAddressByIP(operLog.getOperip()));
                try {
                    SpringUtils.getBean(com.rufeng.business.system.service.ISysOperLogService.class).add(operLog);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
