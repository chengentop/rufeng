package com.rufeng.business.pms.mapper;

import com.rufeng.business.pms.domain.po.ProductCategory;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 产品分类Mapper接口
 *
 * @author chg
 * @date 2021-03-11
 */
@Repository
public interface IProductCategoryDao extends BaseMapper<ProductCategory> {

}
