package com.rufeng.business.system.controller;


import com.rufeng.business.system.domain.po.SysNotice;
import com.rufeng.business.system.service.ISysNoticeService;
import com.rufeng.core.framework.aspectj.lang.annotation.Log;
import com.rufeng.core.framework.aspectj.lang.enums.BusinessType;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.core.framework.db.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


  
/**
  * 通知公告控制器
  * @version v1.0.0
  * @since jdk1.8+
  */
@RestController
@RequestMapping("/sysnotice")
public class SysNoticeController{
	private Logger log = LoggerFactory.getLogger(SysNoticeController.class);

	@Autowired
	private ISysNoticeService sysnoticeService;	
	
	/**
	 * 获取通知公告
	 * @param notice_id 公告ID
	 * @return ResultData
	 */
	@RequestMapping(value="/get/{id}", method={ RequestMethod.GET, RequestMethod.POST })
	public ResultData get(String notice_id)throws Exception{
		log.debug("###开始查询通知公告， notice_id=[{}].", notice_id);
		//These code is generated by machine, if you want to modify the code, suggest you to remove this line
		return  sysnoticeService.get(notice_id);
	}
	
	/**
	 * 查询通知公告
	 * @param sysnotice 通知公告对象
	 * @return ResultData
	 */
	@RequestMapping(value="/list", method={ RequestMethod.POST })
	public ResultData find(SysNotice sysnotice)throws Exception{
		log.debug("###开始根据条件{}查询通知公告", sysnotice);
		//These code is generated by machine, if you want to modify the code, suggest you to remove this line
		return sysnoticeService.find(sysnotice);
	}
	
	
	/**
	 * 分页查询通知公告
	 * @param page 分页对象
	 * @param sysnotice 通知公告对象
	 * @return ResultData
	 */
	@RequestMapping(value="/list-by-page", method={ RequestMethod.POST })
	public ResultData listPager(SysNotice sysnotice,Pager page)throws Exception{
		log.debug("###开始根据条件{}分页查询通知公告", sysnotice);
			return sysnoticeService.listPager(sysnotice,page);
	}
	
	/**
	 * 添加通知公告
	 * @param sysnotice 通知公告对象
	 * @return ResultData
	 */
	@Log(title = "添加通知公告", businessType = BusinessType.INSERT)
	@RequestMapping(value="/add", method={ RequestMethod.POST })
	public ResultData add(SysNotice sysnotice)throws Exception{
		log.debug("###开始查找添加通知公告， [{}]", sysnotice);
		//These code is generated by machine, if you want to modify the code, suggest you to remove this line
		return sysnoticeService.add(sysnotice);
	}
	
	/**
	 * 更新通知公告
	 * @param sysnotice 通知公告对象
	 * @return ResultData
	 */
	@Log(title = "更新通知公告", businessType = BusinessType.UPDATE)
	@RequestMapping(value="/update", method={ RequestMethod.POST })
	public ResultData update(SysNotice sysnotice)throws Exception{
		log.debug("###开始修改通知公告， [{}]", sysnotice);
		//These code is generated by machine, if you want to modify the code, suggest you to remove this line
		return sysnoticeService.update(sysnotice);
	}
	
	/**
	 * 删除通知公告
	 * @param notice_id 公告ID
	 * @return ResultData
	 */
	@Log(title = "删除通知公告", businessType = BusinessType.DELETE)
	@RequestMapping(value="/delete/{id}", method={ RequestMethod.POST })
	public ResultData delete(String notice_id  )throws Exception{
		log.debug("###开始删除通知公告对象，notice_id={}.", notice_id);
		//These code is generated by machine, if you want to modify the code, suggest you to remove this line
		return sysnoticeService.delete(notice_id);
	}
}