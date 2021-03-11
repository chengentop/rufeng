package com.rufeng.business.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rufeng.business.system.domain.po.SysConfig;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;


/**
 * 参数配置 服务接口
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
public interface ISysConfigService extends IService<SysConfig> {

    /**
     * 获取参数配置
     *
     * @param config_id 参数主键
     * @return ResultData
     * @throws Exception
     */
    public ResultData get(String config_id) throws Exception;

    /**
     * 查询参数配置
     *
     * @param sysconfig 参数配置对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData list(SysConfig sysconfig) throws Exception;

    /**
     * 分页查询参数配置
     *
     * @param sysconfig 参数配置对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData listPager(SysConfig sysconfig, Pager page) throws Exception;

    /**
     * 添加参数配置
     *
     * @param sysconfig 参数配置对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData add(SysConfig sysconfig) throws Exception;

    /**
     * 更新参数配置
     *
     * @param sysconfig 参数配置对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData update(SysConfig sysconfig) throws Exception;

    /**
     * 删除参数配置
     *
     * @param config_id 参数主键
     * @return ResultData
     * @throws Exception
     */
    public ResultData delete(String config_id) throws Exception;

    /**
     * 根据参数键名查询参数值
     *
     * @param configKey
     * @return
     */
    public ResultData selectConfigByKey(String configKey);

    /**
     * 清楚缓存
     *
     * @return
     */
    public void clearCache();
}