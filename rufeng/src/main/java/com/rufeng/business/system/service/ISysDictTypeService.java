package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysDictType;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;


/**
  * 字典类型 服务接口
  * @version v1.0.0
  * @since jdk1.8+
  */
public interface ISysDictTypeService {
	
	/**
	 * 获取字典类型
	 * @param dict_id 字典主键
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData get(String dict_id) throws Exception;
	
	/**
	 * 查询字典类型
	 * @param sysdicttype 字典类型对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData list(SysDictType sysdicttype) throws Exception;
	
	/**
	 * 分页查询字典类型
	 * @param sysdicttype 字典类型对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData listPager(SysDictType sysdicttype,Pager page) throws Exception;
	
	/**
	 * 添加字典类型
	 * @param sysdicttype 字典类型对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData add(SysDictType sysdicttype) throws Exception;
	
	/**
	 * 更新字典类型
	 * @param sysdicttype 字典类型对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData update(SysDictType sysdicttype) throws Exception;
	
	/**
	 * 删除字典类型
	 * @param dict_id 字典主键
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData delete(String dict_id) throws Exception;

	/**
	 * 清空緩存
	 * @return
	 */
	public ResultData clearCache();
}