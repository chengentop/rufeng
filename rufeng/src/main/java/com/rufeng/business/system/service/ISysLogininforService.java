package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysLogininfor;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;


/**
 * 系统访问记录 服务接口
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
public interface ISysLogininforService {

    /**
     * 获取系统访问记录
     *
     * @param info_id 访问ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData get(String info_id) throws Exception;

    /**
     * 查询系统访问记录
     *
     * @param syslogininfor 系统访问记录对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData list(SysLogininfor syslogininfor) throws Exception;

    /**
     * 分页查询系统访问记录
     *
     * @param syslogininfor 系统访问记录对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData listPager(SysLogininfor syslogininfor, Pager page) throws Exception;

    /**
     * 添加系统访问记录
     *
     * @param syslogininfor 系统访问记录对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData add(SysLogininfor syslogininfor) throws Exception;

    /**
     * 删除系统访问记录
     *
     * @param info_id 访问ID
     * @return ResultData
     * @throws Exception
     */
    public ResultData delete(String info_id) throws Exception;

    /**
     * 清空记录
     *  @return
     */
    public ResultData cleanLogininfor();
}