package com.rufeng.business.system.domain.po;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * sysdictdata 数据持久化对象
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@TableName("sys_dict_data")
public class SysDictData implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long dictcode;  //字典编码
    private Long dictsort;  //字典排序
    private String dictlabel;  //字典标签
    private String dictvalue;  //字典键值
    private String dicttype;  //字典类型
    private String cssclass;  //样式属性（其他样式扩展）
    private String listclass;  //表格回显样式
    private String isdefault;  //是否默认（Y是 N否）
    private String status;  //状态（0正常 1停用）
    private String createby;  //创建者
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Timestamp createtime;  //创建时间
    private String updateby;  //更新者
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Timestamp updatetime;  //更新时间
    private String remark;  //备注

    public Long getDictcode() {
        return this.dictcode;
    }

    public void setDictcode(Long dictcode) {
        this.dictcode = dictcode;
    }

    public Long getDictsort() {
        return this.dictsort;
    }

    public void setDictsort(Long dictsort) {
        this.dictsort = dictsort;
    }

    public String getDictlabel() {
        return this.dictlabel;
    }

    public void setDictlabel(String dictlabel) {
        this.dictlabel = dictlabel;
    }

    public String getDictvalue() {
        return this.dictvalue;
    }

    public void setDictvalue(String dictvalue) {
        this.dictvalue = dictvalue;
    }

    public String getDicttype() {
        return this.dicttype;
    }

    public void setDicttype(String dicttype) {
        this.dicttype = dicttype;
    }

    public String getCssclass() {
        return this.cssclass;
    }

    public void setCssclass(String cssclass) {
        this.cssclass = cssclass;
    }

    public String getListclass() {
        return this.listclass;
    }

    public void setListclass(String listclass) {
        this.listclass = listclass;
    }

    public String getIsdefault() {
        return this.isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateby() {
        return this.createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getUpdateby() {
        return this.updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public Timestamp getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("com.rufeng: ");
        if (null != dictcode) sb.append("dictcode=").append(dictcode).append(",");
        if (null != dictsort) sb.append("dictsort=").append(dictsort).append(",");
        if (null != dictlabel) sb.append("dictlabel=").append(dictlabel).append(",");
        if (null != dictvalue) sb.append("dictvalue=").append(dictvalue).append(",");
        if (null != dicttype) sb.append("dicttype=").append(dicttype).append(",");
        if (null != cssclass) sb.append("cssclass=").append(cssclass).append(",");
        if (null != listclass) sb.append("listclass=").append(listclass).append(",");
        if (null != isdefault) sb.append("isdefault=").append(isdefault).append(",");
        if (null != status) sb.append("status=").append(status).append(",");
        if (null != createby) sb.append("createby=").append(createby).append(",");
        if (null != createtime) sb.append("createtime=").append(createtime).append(",");
        if (null != updateby) sb.append("updateby=").append(updateby).append(",");
        if (null != updatetime) sb.append("updatetime=").append(updatetime).append(",");
        if (null != remark) sb.append("remark=").append(remark).append(",");
        return sb.toString();
    }
}