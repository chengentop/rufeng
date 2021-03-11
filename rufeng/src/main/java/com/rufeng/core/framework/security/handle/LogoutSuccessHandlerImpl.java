package com.rufeng.core.framework.security.handle;

import com.alibaba.fastjson.JSON;
import com.rufeng.core.framework.common.constant.Constants;
import com.rufeng.core.framework.common.constant.HttpStatus;
import com.rufeng.core.framework.manager.AsyncManager;
import com.rufeng.core.framework.manager.factory.AsyncFactory;
import com.rufeng.core.framework.security.LoginUser;
import com.rufeng.core.framework.security.service.TokenService;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.core.utils.ServletUtils;
import com.rufeng.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义退出处理类 返回成功
 *
 * @author ruoyi
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     *
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)) {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, "退出成功"));
        }
        ServletUtils.renderString(response, JSON.toJSONString(new ResultData(HttpStatus.SUCCESS, "退出成功")));
    }
}
