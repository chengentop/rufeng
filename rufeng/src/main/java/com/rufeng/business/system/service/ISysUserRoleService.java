package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysUserRole;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;


/**
  * 用户和角色关联 服务接口
  * @version v1.0.0
  * @since jdk1.8+
  */
public interface ISysUserRoleService {
	
	/**
	 * 获取用户和角色关联
	 * @param role_id 用户ID
	 * @param user_id 角色ID
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData get(String role_id, String user_id) throws Exception;
	
	/**
	 * 查询用户和角色关联
	 * @param sysuserrole 用户和角色关联对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData find(SysUserRole sysuserrole) throws Exception;
	
	/**
	 * 分页查询用户和角色关联
	 * @param sysuserrole 用户和角色关联对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData listPager(SysUserRole sysuserrole,Pager page) throws Exception;
	
	/**
	 * 添加用户和角色关联
	 * @param sysuserrole 用户和角色关联对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData add(SysUserRole sysuserrole) throws Exception;
	
	/**
	 * 更新用户和角色关联
	 * @param sysuserrole 用户和角色关联对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData update(SysUserRole sysuserrole) throws Exception;
	
	/**
	 * 删除用户和角色关联
	 * @param role_id 用户ID
	 * @param user_id 角色ID
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData delete(String role_id,String user_id) throws Exception;
}