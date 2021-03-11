package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysOperLog;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;


/**
  * 操作日志记录 服务接口
  * @version v1.0.0
  * @since jdk1.8+
  */
public interface ISysOperLogService {
	
	/**
	 * 获取操作日志记录
	 * @param oper_id 日志主键
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData get(String oper_id) throws Exception;
	
	/**
	 * 查询操作日志记录
	 * @param sysoperlog 操作日志记录对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData list(SysOperLog sysoperlog) throws Exception;
	
	/**
	 * 分页查询操作日志记录
	 * @param sysoperlog 操作日志记录对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData listPager(SysOperLog sysoperlog,Pager page) throws Exception;
	
	/**
	 * 添加操作日志记录
	 * @param sysoperlog 操作日志记录对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData add(SysOperLog sysoperlog) throws Exception;
	
	/**
	 * 更新操作日志记录
	 * @param sysoperlog 操作日志记录对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData update(SysOperLog sysoperlog) throws Exception;
	
	/**
	 * 删除操作日志记录
	 * @param oper_id 日志主键
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData delete(String oper_id) throws Exception;
}