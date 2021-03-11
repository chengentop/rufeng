package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysUserPost;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;


/**
 * 用户与岗位关联 服务接口
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
public interface ISysUserPostService {

    /**
     * 获取用户与岗位关联
     *
     * @param post_id 用户ID
     * @param user_id 岗位ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData get(String post_id, String user_id) throws Exception;

    /**
     * 查询用户与岗位关联
     *
     * @param sysuserpost 用户与岗位关联对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData find(SysUserPost sysuserpost) throws Exception;

    /**
     * 分页查询用户与岗位关联
     *
     * @param sysuserpost 用户与岗位关联对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData listPager(SysUserPost sysuserpost, Pager page) throws Exception;

    /**
     * 添加用户与岗位关联
     *
     * @param sysuserpost 用户与岗位关联对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData add(SysUserPost sysuserpost) throws Exception;

    /**
     * 更新用户与岗位关联
     *
     * @param sysuserpost 用户与岗位关联对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData update(SysUserPost sysuserpost) throws Exception;

    /**
     * 删除用户与岗位关联
     *
     * @param post_id 用户ID
     * @param user_id 岗位ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData delete(String post_id, String user_id) throws Exception;
}