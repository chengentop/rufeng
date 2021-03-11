package com.rufeng.business.pms.domain.po;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 产品分类对象 pms_product_category
 *
 * @author chg
 * @date 2021-03-11
 */
@TableName(value = "pms_product_category")
public class ProductCategory{
    private static final long serialVersionUID = 1L;


    /** 主键id */
    @TableId(type = IdType.AUTO)
    private Long id;


    /** 上机分类的编号：0表示一级分类 */
    private Long parentid;


    /** 名称 */
    private String name;


    /** 分类级别：0->1级；1->2级 */
    private Long level;


    /** 商品数量 */
    private Long productcount;


    /** 商品单位 */
    private String productunit;


    /** 是否显示在导航栏：0->不显示；1->显示 */
    private Long navstatus;


    /** 显示状态：0->不显示；1->显示 */
    private Long showstatus;


    /** 排序 */
    private Long sort;


    /** 图标 */
    private String icon;


    /** 关键字 */
    private String keywords;


    /** 描述 */
    private String description;


    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date intime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setParentid(Long parentid)
    {
        this.parentid = parentid;
    }

    public Long getParentid()
    {
        return parentid;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setLevel(Long level)
    {
        this.level = level;
    }

    public Long getLevel()
    {
        return level;
    }
    public void setProductcount(Long productcount)
    {
        this.productcount = productcount;
    }

    public Long getProductcount()
    {
        return productcount;
    }
    public void setProductunit(String productunit)
    {
        this.productunit = productunit;
    }

    public String getProductunit()
    {
        return productunit;
    }
    public void setNavstatus(Long navstatus)
    {
        this.navstatus = navstatus;
    }

    public Long getNavstatus()
    {
        return navstatus;
    }
    public void setShowstatus(Long showstatus)
    {
        this.showstatus = showstatus;
    }

    public Long getShowstatus()
    {
        return showstatus;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }
    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getIcon()
    {
        return icon;
    }
    public void setKeywords(String keywords)
    {
        this.keywords = keywords;
    }

    public String getKeywords()
    {
        return keywords;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setIntime(Date intime)
    {
        this.intime = intime;
    }

    public Date getIntime()
    {
        return intime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentid", getParentid())
            .append("name", getName())
            .append("level", getLevel())
            .append("productcount", getProductcount())
            .append("productunit", getProductunit())
            .append("navstatus", getNavstatus())
            .append("showstatus", getShowstatus())
            .append("sort", getSort())
            .append("icon", getIcon())
            .append("keywords", getKeywords())
            .append("description", getDescription())
            .append("intime", getIntime())
            .toString();
    }
}
