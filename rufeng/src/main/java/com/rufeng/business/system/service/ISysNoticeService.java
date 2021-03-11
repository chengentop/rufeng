package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysNotice;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;


/**
  * 通知公告 服务接口
  * @version v1.0.0
  * @since jdk1.8+
  */
public interface ISysNoticeService {
	
	/**
	 * 获取通知公告
	 * @param notice_id 公告ID
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData get(String notice_id) throws Exception;
	
	/**
	 * 查询通知公告
	 * @param sysnotice 通知公告对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData find(SysNotice sysnotice) throws Exception;
	
	/**
	 * 分页查询通知公告
	 * @param sysnotice 通知公告对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData listPager(SysNotice sysnotice,Pager page) throws Exception;
	
	/**
	 * 添加通知公告
	 * @param sysnotice 通知公告对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData add(SysNotice sysnotice) throws Exception;
	
	/**
	 * 更新通知公告
	 * @param sysnotice 通知公告对象
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData update(SysNotice sysnotice) throws Exception;
	
	/**
	 * 删除通知公告
	 * @param notice_id 公告ID
	 * @return ResultData
	 * @throws Exception
	 */
	public ResultData delete(String notice_id) throws Exception;
}