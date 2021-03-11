package com.rufeng.business.system.controller;

import com.rufeng.business.system.domain.po.SysMenu;
import com.rufeng.business.system.domain.po.SysUser;
import com.rufeng.business.system.domain.vo.RouterVo;
import com.rufeng.business.system.service.ISysMenuService;
import com.rufeng.core.framework.common.constant.Constants;
import com.rufeng.core.framework.security.LoginBody;
import com.rufeng.core.framework.security.LoginUser;
import com.rufeng.core.framework.security.service.SysLoginService;
import com.rufeng.core.framework.security.service.SysPermissionService;
import com.rufeng.core.framework.security.service.TokenService;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.core.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * 参数配置控制器
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@RestController
public class AuthLoginController {
    private Logger log = LoggerFactory.getLogger(AuthLoginController.class);

    @Autowired
    private SysLoginService loginService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private SysPermissionService permissionService;

    /**
     * 登录方法
     *
     * @param loginBody
     * @return token
     */
    @PostMapping("/login")
    public ResultData login(@RequestBody LoginBody loginBody) {
        ResultData data = ResultData.init();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        data.setData(Constants.TOKEN, token);
        return data;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public ResultData getInfo() {
        ResultData data = ResultData.init();
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);

        data.setData("user", user);
        data.setData("roles", roles);
        data.setData("permissions", permissions);
        return data;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public ResultData getRouters() {
        ResultData data = ResultData.init();
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> sysMenus = menuService.selectMenuTreeByUserId(user.getUserid());
        List<RouterVo> routerVos = menuService.buildMenus(sysMenus);
        data.setData("meulist", routerVos);
        return data;
    }

}
