package com.rufeng.business.system.domain.po;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;

/**
  * sysrolemenu 数据持久化对象
  * @version v1.0.0
  * @since jdk1.8+
  */
@TableName("sys_role_menu")
public class SysRoleMenu implements Serializable{
	private static final long serialVersionUID = 1L;    
	
	private Long roleid;  //角色ID
	private Long menuid;  //菜单ID
	
	public Long getRoleid(){
		return this.roleid;
	}
	public void setRoleid(Long roleid){
		this.roleid = roleid;
	}
	public Long getMenuid(){
		return this.menuid;
	}
	public void setMenuid(Long menuid){
		this.menuid = menuid;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("com.rufeng: ");
		if(null != roleid)sb.append("roleid=").append(roleid).append(",");
		if(null != menuid)sb.append("menuid=").append(menuid).append(",");
		return sb.toString();
	}
}