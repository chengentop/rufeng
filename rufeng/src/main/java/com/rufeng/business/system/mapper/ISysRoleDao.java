package com.rufeng.business.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rufeng.business.system.domain.po.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysRoleDao 数据访问对象
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Repository
public interface ISysRoleDao extends BaseMapper<SysRole> {

    /**
     * 根据用户ID查询角色
     *
     * @param user_id 用户ID
     * @return 角色列表
     */
    List<SysRole> selectRolePermissionByUserId(Long user_id);

    /**
     * 根据用户ID获取角色选择框列表
     *
     * @param userId 用户ID
     * @return 选中角色ID列表
     */
    List<Integer> selectRoleListByUserId(Long userId);

    List<SysRole> selectRolesByUserName(String userName);
}