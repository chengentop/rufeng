package com.rufeng.business.pms.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;

import com.rufeng.business.pms.domain.po.ProductCategory;

/**
 * 产品分类Service接口
 *
 * @author chg
 * @date 2021-03-11
 */
public interface IProductCategoryService extends IService<ProductCategory> {
    /**
     * 查询产品分类
     *
     * @param id 产品分类ID
     * @return 产品分类
     */
    public ResultData get(Long id);

    /**
     * 查询产品分类列表
     *
     * @param productCategory 产品分类
     * @return 产品分类集合
     */
    public ResultData list(ProductCategory productCategory);

    /**
     * 分页查询产品分类列表
     *
     * @param productCategory 产品分类
     * @param page 分页对象
     * @return 产品分类集合
     */
    public ResultData listPager(ProductCategory productCategory, Pager page);

    /**
     * 新增产品分类
     *
     * @param productCategory 产品分类
     * @return 结果
     */
    public ResultData add(ProductCategory productCategory);

    /**
     * 修改产品分类
     *
     * @param productCategory 产品分类
     * @return 结果
     */
    public ResultData update(ProductCategory productCategory);

    /**
     * 删除产品分类信息
     *
     * @param id 产品分类ID
     * @return 结果
     */
    public ResultData delete(Long id);
}
