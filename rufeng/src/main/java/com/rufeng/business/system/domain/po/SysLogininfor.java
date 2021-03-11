package com.rufeng.business.system.domain.po;

import java.io.Serializable;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
  * syslogininfor 数据持久化对象
  * @version v1.0.0
  * @since jdk1.8+
  */
@TableName("sys_logininfor")
public class SysLogininfor implements Serializable{
	private static final long serialVersionUID = 1L;    
	
	private Long infoid;  //访问ID
	private String username;  //用户账号
	private String ipaddr;  //登录IP地址
	private String loginlocation;  //登录地点
	private String browser;  //浏览器类型
	private String os;  //操作系统
	private String status;  //登录状态（0成功 1失败）
	private String msg;  //提示消息
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
	private Timestamp logintime;  //访问时间
	
	public Long getInfoid(){
		return this.infoid;
	}
	public void setInfoid(Long infoid){
		this.infoid = infoid;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getIpaddr(){
		return this.ipaddr;
	}
	public void setIpaddr(String ipaddr){
		this.ipaddr = ipaddr;
	}
	public String getLoginlocation(){
		return this.loginlocation;
	}
	public void setLoginlocation(String loginlocation){
		this.loginlocation = loginlocation;
	}
	public String getBrowser(){
		return this.browser;
	}
	public void setBrowser(String browser){
		this.browser = browser;
	}
	public String getOs(){
		return this.os;
	}
	public void setOs(String os){
		this.os = os;
	}
	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getMsg(){
		return this.msg;
	}
	public void setMsg(String msg){
		this.msg = msg;
	}
	public Timestamp getLogintime(){
		return this.logintime;
	}
	public void setLogintime(Timestamp logintime){
		this.logintime = logintime;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("com.rufeng: ");
		if(null != infoid)sb.append("infoid=").append(infoid).append(",");
		if(null != username)sb.append("username=").append(username).append(",");
		if(null != ipaddr)sb.append("ipaddr=").append(ipaddr).append(",");
		if(null != loginlocation)sb.append("loginlocation=").append(loginlocation).append(",");
		if(null != browser)sb.append("browser=").append(browser).append(",");
		if(null != os)sb.append("os=").append(os).append(",");
		if(null != status)sb.append("status=").append(status).append(",");
		if(null != msg)sb.append("msg=").append(msg).append(",");
		if(null != logintime)sb.append("logintime=").append(logintime).append(",");
		return sb.toString();
	}
}