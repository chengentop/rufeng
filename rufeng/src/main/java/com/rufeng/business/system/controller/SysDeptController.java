package com.rufeng.business.system.controller;


import com.rufeng.business.system.domain.po.SysDept;
import com.rufeng.business.system.service.ISysDeptService;
import com.rufeng.core.framework.aspectj.lang.annotation.Log;
import com.rufeng.core.framework.aspectj.lang.enums.BusinessType;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


/**
 * 部门控制器
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@RestController
@RequestMapping("/system/sysdept")
public class SysDeptController {
    private Logger log = LoggerFactory.getLogger(SysDeptController.class);

    @Autowired
    private ISysDeptService sysdeptService;

    /**
     * 获取部门
     *
     * @param deptid 部门id
     * @return ResultData
     */
    @Log(title = "获取部门", businessType = BusinessType.SELECT)
    @RequestMapping(value = "/get/{deptid}", method = {RequestMethod.GET})
    public ResultData get(@PathVariable String deptid) throws Exception {
        log.debug("###开始查询部门， deptid=[{}].", deptid);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        return sysdeptService.get(deptid);
    }

    /**
     * 查询部门
     *
     * @param sysdept 部门对象
     * @return ResultData
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ResultData list(SysDept sysdept) throws Exception {
        log.debug("###开始根据条件{}查询部门", sysdept);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        return sysdeptService.list(sysdept);
    }


    /**
     * 分页查询部门
     *
     * @param page    分页对象
     * @param sysdept 部门对象
     * @return ResultData
     */
    @RequestMapping(value = "/list-by-page", method = {RequestMethod.GET})
    public ResultData listPager(SysDept sysdept, Pager page) throws Exception {
        log.debug("###开始根据条件{}分页查询部门", sysdept);
        return sysdeptService.listPager(sysdept, page);
    }

    /**
     * 添加部门
     *
     * @param sysdept 部门对象
     * @return ResultData
     */
    @Log(title = "添加部门", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public ResultData add(@RequestBody SysDept sysdept) throws Exception {
        log.debug("###开始查找添加部门， [{}]", sysdept);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        return sysdeptService.add(sysdept);
    }

    /**
     * 更新部门
     *
     * @param sysdept 部门对象
     * @return ResultData
     */
    @Log(title = "更新部门", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    public ResultData update(@RequestBody SysDept sysdept) throws Exception {
        log.debug("###开始修改部门， [{}]", sysdept);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        return sysdeptService.update(sysdept);
    }

    /**
     * 删除部门
     *
     * @param deptid 部门id
     * @return ResultData
     */
    @Log(title = "删除部门", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delete/{deptid}", method = {RequestMethod.DELETE})
    public ResultData delete(@PathVariable String deptid) throws Exception {
        log.debug("###开始删除部门对象，deptid={}.", deptid);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        return sysdeptService.delete(deptid);
    }

    /**
     * 获取部门下拉树列表
     */
    @RequestMapping(value = "/treeselect", method = RequestMethod.GET)
    public ResultData treeselect(SysDept dept) {
        log.debug("###开始获取部门下拉树列表，dept={}.", dept);
        List<SysDept> sysDepts = sysdeptService.selectDeptList(dept);
        return sysdeptService.buildDeptTreeSelect(sysDepts);
    }

    /**
     * 查询部门列表（排除节点）
     */
    @RequestMapping(value = "/list/exclude/{deptid}", method = RequestMethod.GET)
    public ResultData excludeChild(@PathVariable(value = "deptid", required = false) Long deptid) {
        log.debug("###开始查询部门列表（排除节点），deptid={}.", deptid);
        ResultData data = ResultData.init();
        List<SysDept> depts = sysdeptService.selectDeptList(new SysDept());
        Iterator<SysDept> it = depts.iterator();
        while (it.hasNext()) {
            SysDept d = (SysDept) it.next();
            if (d.getDeptid().intValue() == deptid
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), deptid + "")) {
                it.remove();
            }
        }
        data.setData("nomenus", depts);
        return data;
    }
}