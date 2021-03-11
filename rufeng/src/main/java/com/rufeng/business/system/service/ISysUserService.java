package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysUser;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;

import javax.servlet.http.HttpServletResponse;


/**
 * 用户信息 服务接口
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
public interface ISysUserService {

    /**
     * 获取用户信息
     *
     * @param user_id 用户ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData get(String user_id) throws Exception;

    /**
     * 查询用户信息
     *
     * @param sysuser 用户信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData find(SysUser sysuser) throws Exception;

    /**
     * 分页查询用户信息
     *
     * @param sysuser 用户信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData listPager(SysUser sysuser, Pager page) throws Exception;

    /**
     * 添加用户信息
     *
     * @param sysuser 用户信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData add(SysUser sysuser) throws Exception;

    /**
     * 更新用户信息
     *
     * @param sysuser 用户信息对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData update(SysUser sysuser) throws Exception;

    /**
     * 删除用户信息
     *
     * @param user_id 用户ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData delete(String user_id) throws Exception;

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByUserName(String username);

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    public void checkUserAllowed(SysUser user);

    /**
     * 修改用户状态
     *
     * @param user 用户信息
     * @return 结果
     */
    public ResultData updateUserStatus(SysUser user);

    /**
     * 重置用户密码
     *
     * @param user 用户信息
     * @return 结果
     */
    public ResultData resetPwd(SysUser user);

    /**
     * 重置用户密码
     *
     * @param userName 用户名
     * @param password 密码
     * @return 结果
     */
    public ResultData resetUserPwd(String userName, String password);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public SysUser selectUserById(Long userId);


    /**
     * 根据用户名查询用户所属角色组
     *
     * @param userName 用户名
     * @return 结果
     */
    public String selectUserRoleGroup(String userName);

    /**
     * 根据用户名查询用户所属岗位组
     *
     * @param userName 用户名
     * @return 结果
     */
    public String selectUserPostGroup(String userName);

    /**
     * 更新用户头像
     *
     * @param username
     * @param avatar
     * @return
     */
    public boolean updateUserAvatar(String username, String avatar);

    /**
     * 获取用户头像
     *
     * @param userid
     * @param reponse
     */
    public void userAvatar(Long userid, HttpServletResponse reponse);
}