package com.rufeng.business.system.controller;


import com.rufeng.business.system.domain.po.SysUser;
import com.rufeng.business.system.service.ISysUserService;
import com.rufeng.core.framework.aspectj.lang.annotation.Log;
import com.rufeng.core.framework.aspectj.lang.enums.BusinessType;
import com.rufeng.core.framework.config.RuFengfConfig;
import com.rufeng.core.framework.exception.CustomException;
import com.rufeng.core.framework.security.LoginUser;
import com.rufeng.core.framework.security.service.TokenService;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.core.utils.SecurityUtils;
import com.rufeng.core.utils.ServletUtils;
import com.rufeng.core.utils.file.FileUploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 个人信息 业务处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/sysuser/profile")
public class SysProfileController {
    private Logger log = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    private ISysUserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 个人信息
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData profile() {
        log.debug("###开始获取个人信息");
        ResultData data = ResultData.init();
        List<Object> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        data.setData("user", user);
        data.setData("roleGroup", userService.selectUserRoleGroup(loginUser.getUsername()));
        data.setData("postGroup", userService.selectUserPostGroup(loginUser.getUsername()));
        return data;
    }

    /**
     * 修改用户
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResultData updateProfile(@RequestBody SysUser user) throws Exception {
        log.debug("###开始修改个人信息, user=[{}]", user);
        Boolean updated = (Boolean) userService.update(user).getData().get("updated");
        if (updated) {
            ResultData data = ResultData.init();
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            // 更新缓存用户信息
            loginUser.getUser().setNickname(user.getNickname());
            loginUser.getUser().setPhonenumber(user.getPhonenumber());
            loginUser.getUser().setEmail(user.getEmail());
            loginUser.getUser().setSex(user.getSex());
            tokenService.setLoginUser(loginUser);
            return data;
        }
        ResultData data = new ResultData(500, "修改个人信息异常，请联系管理员");
        return data;
    }

    /**
     * 重置密码
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/updatePwd", method = RequestMethod.PUT)
    public ResultData updatePwd(String oldPassword, String newPassword) {
        log.debug("###开始重置个人密码, oldPassword=[{}]", oldPassword);
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String userName = loginUser.getUsername();
        String password = loginUser.getPassword();
        if (!SecurityUtils.matchesPassword(oldPassword, password)) {
            throw new CustomException("修改密码失败，旧密码错误");
        }
        if (SecurityUtils.matchesPassword(newPassword, password)) {
            throw new CustomException("新密码不能与旧密码相同");
        }
        Boolean updated = (Boolean) userService.resetUserPwd(userName, SecurityUtils.encryptPassword(newPassword)).getData().get("updated");
        if (updated) {
            // 更新缓存用户密码
            loginUser.getUser().setPassword(SecurityUtils.encryptPassword(newPassword));
            tokenService.setLoginUser(loginUser);

            ResultData data = ResultData.init();
            return data;
        }
        ResultData data = new ResultData(500, "修改密码异常，请联系管理员");
        return data;
    }

    /**
     * 头像上传
     */
    @Log(title = "用户头像", businessType = BusinessType.UPDATE)
    @PostMapping("/avatar")
    public ResultData avatar(@RequestParam("avatarfile") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String avatar = FileUploadUtils.upload(RuFengfConfig.getAvatarPath(), file);
            if (userService.updateUserAvatar(loginUser.getUsername(), avatar)) {
                ResultData data = ResultData.init();
                data.setData("imgUrl", avatar);
                // 更新缓存用户头像
                loginUser.getUser().setAvatar(avatar);
                tokenService.setLoginUser(loginUser);
                return data;
            }
        }
        ResultData data = new ResultData(500, "上传图片异常，请联系管理员");
        return data;
    }
}
