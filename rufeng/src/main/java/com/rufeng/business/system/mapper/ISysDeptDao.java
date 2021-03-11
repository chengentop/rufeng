package com.rufeng.business.system.mapper;

import com.rufeng.business.system.domain.po.SysDept;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * SysDeptDao 数据访问对象
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Repository
public interface ISysDeptDao extends BaseMapper<SysDept> {
    /**
     * 获取部门下拉树列表
     */
    public List<SysDept> selectDeptList(SysDept sysDept);
}
