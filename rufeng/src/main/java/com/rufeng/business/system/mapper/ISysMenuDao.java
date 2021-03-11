package com.rufeng.business.system.mapper;

import com.rufeng.business.system.domain.po.SysMenu;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * SysMenuDao 数据访问对象
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Repository
public interface ISysMenuDao extends BaseMapper<SysMenu> {
    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectMenuPermsByUserId(Long userId);

    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 根据用户所有权限
     *
     * @return 权限列表
     */
    public List<SysMenu> selectMenuTreeAll();

    /**
     * 根据用户查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuListByUserId(SysMenu menu);

    public List<Integer> selectMenuListByRoleId(Long role_id);
}