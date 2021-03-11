package com.rufeng.business.monitor.controller;

import com.rufeng.business.monitor.domian.SysUserOnline;
import com.rufeng.business.monitor.service.ISysUserOnlineService;
import com.rufeng.core.framework.common.constant.Constants;
import com.rufeng.core.framework.redis.RedisCache;

import com.rufeng.core.framework.security.LoginUser;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 在线用户监控
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/online")
public class SysUserOnlineController {

    @Autowired
    private ISysUserOnlineService sysUserOnlineService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 获取在线用户列表
     *
     * @param ipaddr
     * @param userName
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultData list(String ipaddr, String userName) {
        ResultData data = ResultData.init();
        Collection<String> keys = redisCache.keys(Constants.LOGIN_TOKEN_KEY + "*");
        List<SysUserOnline> userOnlineList = new ArrayList<SysUserOnline>();
        for (String key : keys) {
            LoginUser user = redisCache.getCacheObject(key);
            if (StringUtils.isNotEmpty(ipaddr) && StringUtils.isNotEmpty(userName)) {
                if (StringUtils.equals(ipaddr, user.getIpaddr()) && StringUtils.equals(userName, user.getUsername())) {
                    userOnlineList.add(sysUserOnlineService.selectOnlineByInfo(ipaddr, userName, user));
                }
            } else if (StringUtils.isNotEmpty(ipaddr)) {
                if (StringUtils.equals(ipaddr, user.getIpaddr())) {
                    userOnlineList.add(sysUserOnlineService.selectOnlineByIpaddr(ipaddr, user));
                }
            } else if (StringUtils.isNotEmpty(userName) && StringUtils.isNotNull(user.getUser())) {
                if (StringUtils.equals(userName, user.getUsername())) {
                    userOnlineList.add(sysUserOnlineService.selectOnlineByUserName(userName, user));
                }
            } else {
                userOnlineList.add(sysUserOnlineService.loginUserToUserOnline(user));
            }
        }
        Collections.reverse(userOnlineList);
        userOnlineList.removeAll(Collections.singleton(null));
        data.setData("userlist", userOnlineList);
        data.setData("total", userOnlineList.size());
        return data;
    }

    /**
     * 强退用户
     */
    @RequestMapping(value = "/{tokenId}", method = RequestMethod.DELETE)
    public ResultData forceLogout(@PathVariable String tokenId) {
        ResultData data = ResultData.init();
        redisCache.deleteObject(Constants.LOGIN_TOKEN_KEY + tokenId);
        return data;
    }
}
