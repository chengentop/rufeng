package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysPost;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;

import java.util.List;


/**
 * 岗位信息 服务接口
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
public interface ISysPostService {

    /**
     * 获取岗位信息
     *
     * @param post_id 岗位ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData get(String post_id) throws Exception;

    /**
     * 查询岗位信息
     *
     * @param syspost 岗位信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData list(SysPost syspost) throws Exception;

    /**
     * 分页查询岗位信息
     *
     * @param syspost 岗位信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData listPager(SysPost syspost, Pager page) throws Exception;

    /**
     * 添加岗位信息
     *
     * @param syspost 岗位信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData add(SysPost syspost) throws Exception;

    /**
     * 更新岗位信息
     *
     * @param syspost 岗位信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData update(SysPost syspost) throws Exception;

    /**
     * 删除岗位信息
     *
     * @param post_id 岗位ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData delete(String post_id) throws Exception;

    /**
     * 获取岗位信息
     *
     * @return
     */
    public List<SysPost> selectPostAll();

    /**
     * 根据用户ID获取岗位选择框列表
     *
     * @param userId 用户ID
     * @return 选中岗位ID列表
     */
    public List<Integer> selectPostListByUserId(Long user_id);
}