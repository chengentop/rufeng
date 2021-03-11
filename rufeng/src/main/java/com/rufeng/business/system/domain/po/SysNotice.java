package com.rufeng.business.system.domain.po;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
  * sysnotice 数据持久化对象
  * @version v1.0.0
  * @since jdk1.8+
  */
@TableName("sys_notice")
public class SysNotice implements Serializable{
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.AUTO)
	private Long noticeid;  //公告ID
	private String noticetitle;  //公告标题
	private String noticetype;  //公告类型（1通知 2公告）
	private String noticecontent;  //公告内容
	private String status;  //公告状态（0正常 1关闭）
	private String createby;  //创建者
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
	private Timestamp createtime;  //创建时间
	private String updateby;  //更新者
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
	private Timestamp updatetime;  //更新时间
	private String remark;  //备注
	
	public Long getNoticeid(){
		return this.noticeid;
	}
	public void setNoticeid(Long noticeid){
		this.noticeid = noticeid;
	}
	public String getNoticetitle(){
		return this.noticetitle;
	}
	public void setNoticetitle(String noticetitle){
		this.noticetitle = noticetitle;
	}
	public String getNoticetype(){
		return this.noticetype;
	}
	public void setNoticetype(String noticetype){
		this.noticetype = noticetype;
	}
	public String getNoticecontent(){
		return this.noticecontent;
	}
	public void setNoticecontent(String noticecontent){
		this.noticecontent = noticecontent;
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
		if(null != noticeid)sb.append("noticeid=").append(noticeid).append(",");
		if(null != noticetitle)sb.append("noticetitle=").append(noticetitle).append(",");
		if(null != noticetype)sb.append("noticetype=").append(noticetype).append(",");
		if(null != noticecontent)sb.append("noticecontent=").append(noticecontent).append(",");
		if(null != status)sb.append("status=").append(status).append(",");
		if(null != createby)sb.append("createby=").append(createby).append(",");
		if(null != createtime)sb.append("createtime=").append(createtime).append(",");
		if(null != updateby)sb.append("updateby=").append(updateby).append(",");
		if(null != updatetime)sb.append("updatetime=").append(updatetime).append(",");
		if(null != remark)sb.append("remark=").append(remark).append(",");
		return sb.toString();
	}
}