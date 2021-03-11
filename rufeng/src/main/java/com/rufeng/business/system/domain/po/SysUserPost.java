package com.rufeng.business.system.domain.po;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;

/**
  * sys_user_post 数据持久化对象
  * @version v1.0.0
  * @since jdk1.8+
  */
@TableName("sys_user_post")
public class SysUserPost implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long userid;  //用户ID
	private Long postid;  //岗位ID

	public Long getUserid(){
		return this.userid;
	}
	public void setUserid(Long userid){
		this.userid = userid;
	}
	public Long getPostid(){
		return this.postid;
	}
	public void setPostid(Long postid){
		this.postid = postid;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("com.rufeng: ");
		if(null != userid)sb.append("userid=").append(userid).append(",");
		if(null != postid)sb.append("postid=").append(postid).append(",");
		return sb.toString();
	}
}