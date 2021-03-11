package com.rufeng.business.system.mapper;

import com.rufeng.business.system.domain.po.SysNotice;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
    
/**
  * SysNoticeDao 数据访问对象
  * @version v1.0.0
  * @since jdk1.8+
  */
@Repository
public interface ISysNoticeDao extends BaseMapper<SysNotice>{
}