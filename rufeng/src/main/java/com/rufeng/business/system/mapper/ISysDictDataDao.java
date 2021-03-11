package com.rufeng.business.system.mapper;

import com.rufeng.business.system.domain.po.SysDictData;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * SysDictDataDao 数据访问对象
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Repository
public interface ISysDictDataDao extends BaseMapper<SysDictData> {
    public List<SysDictData> selectDictDataByType(String dictType);
}