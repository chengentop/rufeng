package com.rufeng.business.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rufeng.business.system.domain.po.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * SysUserDao 数据访问对象
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Repository
public interface ISysUserDao extends BaseMapper<SysUser> {
    public SysUser selectUserByUserName(String username);

    public IPage<SysUser> selectByPage(Page<SysUser> page, @Param("ew") SysUser sysuser);

    public  SysUser selectUserById(Long userId);

}