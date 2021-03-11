package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysRoleMenu;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;


/**
 * 角色和菜单关联 服务接口
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
public interface ISysRoleMenuService {

    /**
     * 获取角色和菜单关联
     *
     * @param menu_id 角色ID
     * @param role_id 菜单ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData get(String menu_id, String role_id) throws Exception;

    /**
     * 查询角色和菜单关联
     *
     * @param sysrolemenu 角色和菜单关联对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData find(SysRoleMenu sysrolemenu) throws Exception;

    /**
     * 分页查询角色和菜单关联
     *
     * @param sysrolemenu 角色和菜单关联对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData listPager(SysRoleMenu sysrolemenu, Pager page) throws Exception;

    /**
     * 添加角色和菜单关联
     *
     * @param sysrolemenu 角色和菜单关联对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData add(SysRoleMenu sysrolemenu) throws Exception;

    /**
     * 更新角色和菜单关联
     *
     * @param sysrolemenu 角色和菜单关联对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData update(SysRoleMenu sysrolemenu) throws Exception;

    /**
     * 删除角色和菜单关联
     *
     * @param menu_id 角色ID
     * @param role_id 菜单ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData delete(String menu_id, String role_id) throws Exception;
}