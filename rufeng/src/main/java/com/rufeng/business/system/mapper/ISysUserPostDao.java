package com.rufeng.business.system.mapper;

import com.rufeng.business.system.domain.po.SysUserPost;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * SysUserPostDao 数据访问对象
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Repository
public interface ISysUserPostDao extends BaseMapper<SysUserPost> {
    /**
     * 批量新增用户岗位信息
     *
     * @param userPostList 用户角色列表
     * @return 结果
     */
    public int batchUserPost(List<SysUserPost> userPostList);
}