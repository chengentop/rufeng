package com.rufeng.business.system.domain.po;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
  * sysdicttype 数据持久化对象
  * @version v1.0.0
  * @since jdk1.8+
  */
@TableName("sys_dict_type")
public class SysDictType implements Serializable{
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.AUTO)
	private Long dictid;  //字典主键
	private String dictname;  //字典名称
	private String dicttype;  //字典类型
	private String status;  //状态（0正常 1停用）
	private String createby;  //创建者
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
	private Timestamp createtime;  //创建时间
	private String updateby;  //更新者
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
	private Timestamp updatetime;  //更新时间
	private String remark;  //备注
	
	public Long getDictid(){
		return this.dictid;
	}
	public void setDictid(Long dictid){
		this.dictid = dictid;
	}
	public String getDictname(){
		return this.dictname;
	}
	public void setDictname(String dictname){
		this.dictname = dictname;
	}
	public String getDicttype(){
		return this.dicttype;
	}
	public void setDicttype(String dicttype){
		this.dicttype = dicttype;
	}
	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getCreateby(){
		return this.createby;
	}
	public void setCreateby(String createby){
		this.createby = createby;
	}
	public Timestamp getCreatetime(){
		return this.createtime;
	}
	public void setCreatetime(Timestamp createtime){
		this.createtime = createtime;
	}
	public String getUpdateby(){
		return this.updateby;
	}
	public void setUpdateby(String updateby){
		this.updateby = updateby;
	}
	public Timestamp getUpdatetime(){
		return this.updatetime;
	}
	public void setUpdatetime(Timestamp updatetime){
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
		if(null != dictid)sb.append("dictid=").append(dictid).append(",");
		if(null != dictname)sb.append("dictname=").append(dictname).append(",");
		if(null != dicttype)sb.append("dicttype=").append(dicttype).append(",");
		if(null != status)sb.append("status=").append(status).append(",");
		if(null != createby)sb.append("createby=").append(createby).append(",");
		if(null != createtime)sb.append("createtime=").append(createtime).append(",");
		if(null != updateby)sb.append("updateby=").append(updateby).append(",");
		if(null != updatetime)sb.append("updatetime=").append(updatetime).append(",");
		if(null != remark)sb.append("remark=").append(remark).append(",");
		return sb.toString();
	}
}