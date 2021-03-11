package com.rufeng.business.system.service;

import com.rufeng.business.system.domain.po.SysDept;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;

import java.util.List;


/**
 * 部门 服务接口
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
public interface ISysDeptService {

    /**
     * 获取部门
     *
     * @param dept_id 部门id
     * @return ResultData
     * @throws Exception
     */
    public ResultData get(String dept_id) throws Exception;

    /**
     * 查询部门
     *
     * @param sysdept 部门对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData list(SysDept sysdept) throws Exception;

    /**
     * 分页查询部门
     *
     * @param sysdept 部门对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData listPager(SysDept sysdept, Pager page) throws Exception;

    /**
     * 添加部门
     *
     * @param sysdept 部门对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData add(SysDept sysdept) throws Exception;

    /**
     * 更新部门
     *
     * @param sysdept 部门对象
     * @return ResultData
     * @throws Exception
     */
    public ResultData update(SysDept sysdept) throws Exception;

    /**
     * 删除部门
     *
     * @param dept_id 部门id
     * @return ResultData
     * @throws Exception
     */
    public ResultData delete(String dept_id) throws Exception;

    /**
     * 获取部门下拉树列表
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param sysDepts 部门列表
     * @return 下拉树结构列表
     */
    public ResultData buildDeptTreeSelect(List<SysDept> sysDepts);

    /**
     * 构建前端所需要树结构
     *
     * @param depts 部门列表
     * @return 树结构列表
     */
    public List<SysDept> buildDeptTree(List<SysDept> depts);
}