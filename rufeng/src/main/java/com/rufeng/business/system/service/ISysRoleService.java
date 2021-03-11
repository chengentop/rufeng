package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysRole;
import com.rufeng.business.system.domain.po.SysUser;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;

import java.util.List;
import java.util.Set;


/**
 * 角色信息 服务接口
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
public interface ISysRoleService {

    /**
     * 获取角色信息
     *
     * @param role_id 角色ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData get(String role_id) throws Exception;

    /**
     * 查询角色信息
     *
     * @param sysrole 角色信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData find(SysRole sysrole) throws Exception;

    /**
     * 分页查询角色信息
     *
     * @param sysrole 角色信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData listPager(SysRole sysrole, Pager page) throws Exception;

    /**
     * 添加角色信息
     *
     * @param sysrole 角色信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData add(SysRole sysrole) throws Exception;

    /**
     * 更新角色信息
     *
     * @param sysrole 角色信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData update(SysRole sysrole) throws Exception;

    /**
     * 删除角色信息
     *
     * @param role_id 角色ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData delete(String role_id) throws Exception;

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRolePermissionByUserId(Long userId);

    /**
     * 获取所有角色
     *
     * @return
     */
    public List<SysRole> selectRoleAll();

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    public void checkUserAllowed(SysUser user);

    /**
     * 根据用户ID获取角色选择框列表
     *
     * @param userId 用户ID
     * @return 选中角色ID列表
     */
    public List<Integer> selectRoleListByUserId(Long userId);

    /**
     * 校验角色是否允许操作
     *
     * @param role 角色信息
     */
    public void checkRoleAllowed(SysRole role);

    /**
     * 修改角色状态
     *
     * @param role 角色信息
     * @return 结果
     */
    public ResultData updateRoleStatus(SysRole role);

    /**
     * 批量刪除
     * @param roleIds
     * @return
     */
    public ResultData deleteByIds(Long[] roleIds);
}