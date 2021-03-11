package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysRoleDept;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;


/**
  * 角色和部门关联 服务接口
  * @version v1.0.0
  * @since jdk1.8+
  */
public interface ISysRoleDeptService {
	
	/**
	 * 获取角色和部门关联
	 * @param dept_id 角色ID
	 * @param role_id 部门ID
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData get(String dept_id, String role_id) throws Exception;
	
	/**
	 * 查询角色和部门关联
	 * @param sysroledept 角色和部门关联对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData find(SysRoleDept sysroledept) throws Exception;
	
	/**
	 * 分页查询角色和部门关联
	 * @param sysroledept 角色和部门关联对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData listPager(SysRoleDept sysroledept,Pager page) throws Exception;
	
	/**
	 * 添加角色和部门关联
	 * @param sysroledept 角色和部门关联对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData add(SysRoleDept sysroledept) throws Exception;
	
	/**
	 * 更新角色和部门关联
	 * @param sysroledept 角色和部门关联对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData update(SysRoleDept sysroledept) throws Exception;
	
	/**
	 * 删除角色和部门关联
	 * @param dept_id 角色ID
	 * @param role_id 部门ID
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData delete(String dept_id,String role_id) throws Exception;
}