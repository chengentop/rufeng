package com.rufeng.business.system.domain.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * sysmenu 数据持久化对象
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@TableName("sys_menu")
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long menuid;  //菜单ID
    private String menuname;  //菜单名称
    private Long parentid;  //父菜单ID
    private Integer ordernum;  //显示顺序
    private String path;  //路由地址
    private String component;  //组件路径
    private String isframe;  //是否为外链（0是 1否）
    private String menutype;  //菜单类型（M目录 C菜单 F按钮）
    private String visible;  //菜单状态（0显示 1隐藏）
    private String status;  //菜单状态（0正常 1停用）
    private String perms;  //权限标识
    private String icon;  //菜单图标
    private String createby;  //创建者
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Timestamp createtime;  //创建时间
    private String updateby;  //更新者
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Timestamp updatetime;  //更新时间
    private String remark;  //备注
    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<SysMenu> children = new ArrayList<SysMenu>();

    /**
     * 请求参数
     */
    @TableField(exist = false)
    private Map<String, Object> params;

    public Long getMenuid() {
        return this.menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return this.menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public Long getParentid() {
        return this.parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getOrdernum() {
        return this.ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return this.component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIsframe() {
        return this.isframe;
    }

    public void setIsframe(String isframe) {
        this.isframe = isframe;
    }

    public String getMenutype() {
        return this.menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public String getVisible() {
        return this.visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerms() {
        return this.perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("com.rufeng: ");
        if (null != menuid) sb.append("menuid=").append(menuid).append(",");
        if (null != menuname) sb.append("menuname=").append(menuname).append(",");
        if (null != parentid) sb.append("parentid=").append(parentid).append(",");
        if (null != ordernum) sb.append("ordernum=").append(ordernum).append(",");
        if (null != path) sb.append("path=").append(path).append(",");
        if (null != component) sb.append("component=").append(component).append(",");
        if (null != isframe) sb.append("isframe=").append(isframe).append(",");
        if (null != menutype) sb.append("menutype=").append(menutype).append(",");
        if (null != visible) sb.append("visible=").append(visible).append(",");
        if (null != status) sb.append("status=").append(status).append(",");
        if (null != perms) sb.append("perms=").append(perms).append(",");
        if (null != icon) sb.append("icon=").append(icon).append(",");
        if (null != createby) sb.append("createby=").append(createby).append(",");
        if (null != createtime) sb.append("createtime=").append(createtime).append(",");
        if (null != updateby) sb.append("updateby=").append(updateby).append(",");
        if (null != updatetime) sb.append("updatetime=").append(updatetime).append(",");
        if (null != remark) sb.append("remark=").append(remark).append(",");
        return sb.toString();
    }
}