package com.rufeng.business.system.domain.po;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;

/**
  * sys_user_role 数据持久化对象
  * @version v1.0.0
  * @since jdk1.8+
  */
@TableName("sys_user_role")
public class SysUserRole implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long userid;  //用户ID
	private Long roleid;  //角色ID

	public Long getUserid(){
		return this.userid;
	}
	public void setUserid(Long userid){
		this.userid = userid;
	}
	public Long getRoleid(){
		return this.roleid;
	}
	public void setRoleid(Long roleid){
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("com.rufeng: ");
		if(null != userid)sb.append("userid=").append(userid).append(",");
		if(null != roleid)sb.append("roleid=").append(roleid).append(",");
		return sb.toString();
	}
}