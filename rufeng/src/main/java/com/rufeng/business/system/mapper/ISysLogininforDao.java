package com.rufeng.business.system.mapper;

import com.rufeng.business.system.domain.po.SysLogininfor;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * SysLogininforDao 数据访问对象
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Repository
public interface ISysLogininforDao extends BaseMapper<SysLogininfor> {
    /**
     * 清空系统登录日志
     *
     * @return 结果
     */
    public int cleanLogininfor();
}