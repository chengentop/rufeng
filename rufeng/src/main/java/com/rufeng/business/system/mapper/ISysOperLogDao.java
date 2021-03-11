package com.rufeng.business.system.mapper;

import com.rufeng.business.system.domain.po.SysOperLog;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
    
/**
  * SysOperLogDao 数据访问对象
  * @version v1.0.0
  * @since jdk1.8+
  */
@Repository
public interface ISysOperLogDao extends BaseMapper<SysOperLog>{
}