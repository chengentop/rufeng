package com.rufeng.business.system.mapper;

import com.rufeng.business.system.domain.po.SysPost;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * SysPostDao 数据访问对象
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Repository
public interface ISysPostDao extends BaseMapper<SysPost> {
    /**
     * 根据用户ID获取岗位选择框列表
     *
     * @param userId 用户ID
     * @return 选中岗位ID列表
     */
    public List<Integer> selectPostListByUserId(Long user_id);

    List<SysPost> selectPostsByUserName(String userName);
}