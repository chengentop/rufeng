package com.rufeng.business.system.domain.po;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;

/**
  * sysroledept 数据持久化对象
  * @version v1.0.0
  * @since jdk1.8+
  */
@TableName("sys_role_dept")
public class SysRoleDept implements Serializable{
	private static final long serialVersionUID = 1L;    
	
	private Long roleid;  //角色ID
	private Long deptid;  //部门ID
	
	public Long getRoleid(){
		return this.roleid;
	}
	public void setRoleid(Long roleid){
		this.roleid = roleid;
	}
	public Long getDeptid(){
		return this.deptid;
	}
	public void setDeptid(Long deptid){
		this.deptid = deptid;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("com.rufeng: ");
		if(null != roleid)sb.append("roleid=").append(roleid).append(",");
		if(null != deptid)sb.append("deptid=").append(deptid).append(",");
		return sb.toString();
	}
}