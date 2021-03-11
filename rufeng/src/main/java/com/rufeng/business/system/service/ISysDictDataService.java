package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysDictData;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;


/**
 * 字典数据 服务接口
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
public interface ISysDictDataService {

    /**
     * 获取字典数据
     *
     * @param dict_code 字典编码
     * @return ResultData
     * @throws Exception
     */
    public ResultData get(String dict_code) throws Exception;

    /**
     * 查询字典数据
     *
     * @param sysdictdata 字典数据对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData list(SysDictData sysdictdata) throws Exception;

    /**
     * 分页查询字典数据
     *
     * @param sysdictdata 字典数据对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData listPager(SysDictData sysdictdata, Pager page) throws Exception;

    /**
     * 添加字典数据
     *
     * @param sysdictdata 字典数据对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData add(SysDictData sysdictdata) throws Exception;

    /**
     * 更新字典数据
     *
     * @param sysdictdata 字典数据对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData update(SysDictData sysdictdata) throws Exception;

    /**
     * 删除字典数据
     *
     * @param dict_code 字典编码
     * @return ResultData
     * @throws Exception
     */
    public ResultData delete(String dict_code) throws Exception;

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType
     * @return
     */
    public ResultData selectDictDataByType(String dictType);
}