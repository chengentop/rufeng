package com.rufeng.business.system.service.impl;


import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.business.system.service.ISysUserRoleService;
import com.rufeng.business.system.mapper.ISysUserRoleDao;
import com.rufeng.business.system.domain.po.SysUserRole;


/**
 * 用户和角色关联 服务接口实现
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<ISysUserRoleDao , SysUserRole> implements ISysUserRoleService {
    private Logger log = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);

    @Autowired
    private ISysUserRoleDao sysuserroleDao;

    @Override
    public ResultData get(String roleid, String userid) throws Exception {
        log.debug("###[服务] 开始查询用户和角色关联 roleid=[{}]. userid=[{}]. ", roleid, userid);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
//        Map<String, String> param = new HashMap<String, String>();
//        param.put("roleid", roleid);
//        param.put("userid", userid);
//        SysUserRole sysuserrole = sysuserroleDao.get(param);
//        resData.setData("sysuserrole", sysuserrole);
        log.info("###[服务] 完成查询用户和角色关联 ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData find(SysUserRole sysuserrole) throws Exception {
        log.debug("###[服务] 开始根据条件{}查询用户和角色关联", sysuserrole);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        QueryWrapper<SysUserRole> sysuserroleWrapper = new QueryWrapper<>();
        sysuserroleWrapper.setEntity(sysuserrole);
        List<SysUserRole> sysuserroles = sysuserroleDao.selectList(sysuserroleWrapper);
        resData.setData("sysuserroles", sysuserroles);
        log.info("###[服务] 完成查询用户和角色关联 ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData listPager(SysUserRole sysuserrole, Pager page) throws Exception {
        log.debug("###[服务] 开始根据条件{}分页查询用户和角色关联", sysuserrole);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        Page<SysUserRole> pageParam = new Page<>(page.getCurrentPage(), page.getTotalSize()); // 当前页码，每页条数
        QueryWrapper<SysUserRole> sysuserroleWrapper = new QueryWrapper<>();
        sysuserroleWrapper.setEntity(sysuserrole);
        IPage<SysUserRole> pu = sysuserroleDao.selectPage(pageParam, sysuserroleWrapper);
        resData.setData("data", pu);

        log.info("###[服务] 完成分页查询用户和角色关联 resData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData add(SysUserRole sysuserrole) throws Exception {
        log.debug("###[服务] 开始添加新用户和角色关联, {}", sysuserrole);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        int inserted = sysuserroleDao.insert(sysuserrole);
        resData.setData("inserted", inserted);
        log.info("###[服务] 完成添加新用户和角色关联，ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData update(SysUserRole sysuserrole) throws Exception {
        log.debug("###[服务] 开始根据条件{}修改用户和角色关联,", sysuserrole);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        int updated = sysuserroleDao.updateById(sysuserrole);
        resData.setData("updated", updated);
        log.info("###[服务] 完成修改用户和角色关联，ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData delete(String roleid, String userid) throws Exception {
        log.debug("###[服务] 开始根据条件{}删除用户和角色关联,", roleid, userid);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        SysUserRole sysuserrole = new SysUserRole();
        sysuserrole.setRoleid(Long.valueOf(roleid));
        sysuserrole.setUserid(Long.valueOf(userid));
        int deleted = sysuserroleDao.deleteById(sysuserrole);
        resData.setData("deleted", deleted);
        log.info("###[服务] 完成删除用户和角色关联，ResultData=[{}]", resData);
        return resData;
    }

}