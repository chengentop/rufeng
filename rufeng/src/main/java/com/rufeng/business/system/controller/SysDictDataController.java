package com.rufeng.business.system.controller;


import com.rufeng.business.system.domain.po.SysDictData;
import com.rufeng.business.system.service.ISysDictDataService;
import com.rufeng.core.framework.aspectj.lang.annotation.Log;
import com.rufeng.core.framework.aspectj.lang.enums.BusinessType;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.core.framework.db.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 字典数据控制器
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@RestController
@RequestMapping("/system/dict/data")
public class SysDictDataController {
    private Logger log = LoggerFactory.getLogger(SysDictDataController.class);

    @Autowired
    private ISysDictDataService sysdictdataService;

    /**
     * 获取字典数据
     *
     * @param dict_code 字典编码
     * @return ResultData
     */
    @Log(title = "添加字典数据", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/get/{dict_code}", method = {RequestMethod.GET})
    public ResultData get(@PathVariable String dict_code) throws Exception {
        log.debug("###开始查询字典数据， dict_code=[{}].", dict_code);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        return sysdictdataService.get(dict_code);
    }

    /**
     * 查询字典数据
     *
     * @param sysdictdata 字典数据对象
     * @return ResultData
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ResultData list(SysDictData sysdictdata) throws Exception {
        log.debug("###开始根据条件{}查询字典数据", sysdictdata);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        return sysdictdataService.list(sysdictdata);
    }


    /**
     * 分页查询字典数据
     *
     * @param page        分页对象
     * @param sysdictdata 字典数据对象
     * @return ResultData
     */
    @RequestMapping(value = "/list-by-page", method = {RequestMethod.GET})
    public ResultData listPager(SysDictData sysdictdata, Pager page) throws Exception {
        log.debug("###开始根据条件{}分页查询字典数据", sysdictdata);
        return sysdictdataService.listPager(sysdictdata, page);
    }

    /**
     * 添加字典数据
     *
     * @param sysdictdata 字典数据对象
     * @return ResultData
     */
    @Log(title = "添加字典数据", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public ResultData add(@RequestBody SysDictData sysdictdata) throws Exception {
        log.debug("###开始查找添加字典数据， [{}]", sysdictdata);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        return sysdictdataService.add(sysdictdata);
    }

    /**
     * 更新字典数据
     *
     * @param sysdictdata 字典数据对象
     * @return ResultData
     */
    @Log(title = "更新字典数据", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    public ResultData update(@RequestBody SysDictData sysdictdata) throws Exception {
        log.debug("###开始修改字典数据， [{}]", sysdictdata);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        return sysdictdataService.update(sysdictdata);
    }

    /**
     * 删除字典数据
     *
     * @param dict_code 字典编码
     * @return ResultData
     */
    @Log(title = "删除字典数据", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delete/{dict_code}", method = {RequestMethod.DELETE})
    public ResultData delete(@PathVariable String dict_code) throws Exception {
        log.debug("###开始删除字典数据对象，dict_code={}.", dict_code);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        return sysdictdataService.delete(dict_code);
    }

    /**
     * 根据字典类型查询字典数据信息
     */
    @RequestMapping(value = "/type/{dictType}", method = RequestMethod.GET)
    public ResultData dictType(@PathVariable String dictType) {
        log.debug("###开始根据字典类型查询字典数据信息，dictType={}.", dictType);
        return sysdictdataService.selectDictDataByType(dictType);
    }
}