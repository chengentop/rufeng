package com.rufeng.business.system.domain.po;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
  * sys_config 数据持久化对象
  * @version v1.0.0
  * @since jdk1.8+
  */
@TableName("sys_config")
public class SysConfig implements Serializable{
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.AUTO)
	private Long configid;  //参数主键
	private String configname;  //参数名称
	private String configkey;  //参数键名
	private String configvalue;  //参数键值
	private String configtype;  //系统内置（Y是 N否）
	private String createby;  //创建者
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
	private Timestamp createtime;  //创建时间
	private String updateby;  //更新者
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
	private Timestamp updatetime;  //更新时间
	private String remark;  //备注

	public Long getConfigid() {
		return configid;
	}

	public void setConfigid(Long configid) {
		this.configid = configid;
	}

	public String getConfigname() {
		return configname;
	}

	public void setConfigname(String configname) {
		this.configname = configname;
	}

	public String getConfigkey() {
		return configkey;
	}

	public void setConfigkey(String configkey) {
		this.configkey = configkey;
	}

	public String getConfigvalue() {
		return configvalue;
	}

	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}

	public String getConfigtype() {
		return configtype;
	}

	public void setConfigtype(String configtype) {
		this.configtype = configtype;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("com.rufeng: ");
		if(null != configid)sb.append("configid=").append(configid).append(",");
		if(null != configname)sb.append("configname=").append(configname).append(",");
		if(null != configkey)sb.append("configkey=").append(configkey).append(",");
		if(null != configvalue)sb.append("configvalue=").append(configvalue).append(",");
		if(null != configtype)sb.append("configtype=").append(configtype).append(",");
		if(null != createby)sb.append("createby=").append(createby).append(",");
		if(null != createtime)sb.append("createtime=").append(createtime).append(",");
		if(null != updateby)sb.append("updateby=").append(updateby).append(",");
		if(null != updatetime)sb.append("updatetime=").append(updatetime).append(",");
		if(null != remark)sb.append("remark=").append(remark).append(",");
		return sb.toString();
	}
}