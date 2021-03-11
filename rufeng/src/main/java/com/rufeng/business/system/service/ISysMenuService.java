package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysMenu;
import com.rufeng.business.system.domain.vo.RouterVo;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;

import java.util.List;
import java.util.Set;


/**
 * 菜单权限 服务接口
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
public interface ISysMenuService {

    /**
     * 获取菜单权限
     *
     * @param menu_id 菜单ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData get(String menu_id) throws Exception;

    /**
     * 查询菜单权限
     *
     * @param sysmenu 菜单权限对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData list(SysMenu sysmenu) throws Exception;

    /**
     * 分页查询菜单权限
     *
     * @param sysmenu 菜单权限对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData listPager(SysMenu sysmenu, Pager page) throws Exception;

    /**
     * 添加菜单权限
     *
     * @param sysmenu 菜单权限对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData add(SysMenu sysmenu) throws Exception;

    /**
     * 更新菜单权限
     *
     * @param sysmenu 菜单权限对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData update(SysMenu sysmenu) throws Exception;

    /**
     * 删除菜单权限
     *
     * @param menu_id 菜单ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData delete(String menu_id) throws Exception;

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectMenuPermsByUserId(Long userId);

    /**
     * 根据用户ID查询菜单树信息
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 构建前端路由所需要的菜单
     *
     * @param menus 菜单列表
     * @return 路由列表
     */
    public List<RouterVo> buildMenus(List<SysMenu> menus);

    /**
     * 根据用户查询系统菜单列表
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuList(Long userId);

    /**
     * 根据用户查询系统菜单列表
     *
     * @param menu   菜单信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuList(SysMenu menu, Long userId);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param menus 菜单列表
     * @return 下拉树结构列表
     */
    public ResultData buildMenuTreeSelect(List<SysMenu> menus);

    /**
     * 构建前端所需要树结构
     *
     * @param menus 菜单列表
     * @return 树结构列表
     */
    public List<SysMenu> buildMenuTree(List<SysMenu> menus);

    /**
     * 根据角色ID查询菜单树信息
     *
     * @param roleId 角色ID
     * @return 选中菜单列表
     */
    public List<Integer> selectMenuListByRoleId(Long roleId);
}