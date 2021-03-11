package com.rufeng.business.system.service.impl;


import java.util.*;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rufeng.business.system.domain.po.SysRoleMenu;
import com.rufeng.business.system.domain.po.SysUser;
import com.rufeng.core.framework.exception.CustomException;
import com.rufeng.core.utils.SecurityUtils;
import com.rufeng.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.rufeng.core.framework.db.Pager;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.business.system.service.ISysRoleService;
import com.rufeng.business.system.mapper.ISysRoleDao;
import com.rufeng.business.system.domain.po.SysRole;


/**
 * 角色信息 服务接口实现
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<ISysRoleDao, SysRole> implements ISysRoleService {
    private Logger log = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    private ISysRoleDao sysroleDao;
    @Autowired
    private SysRoleMenuServiceImpl roleMenuService;

    @Override
    public ResultData get(String roleid) throws Exception {
        log.debug("###[服务] 开始查询角色信息 roleid=[{}]. ", roleid);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        SysRole sysrole = sysroleDao.selectById(roleid);
        resData.setData("sysrole", sysrole);
        log.info("###[服务] 完成查询角色信息 ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData find(SysRole sysrole) throws Exception {
        log.debug("###[服务] 开始根据条件{}查询角色信息", sysrole);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        QueryWrapper<SysRole> sysroleWrapper = new QueryWrapper<>();
        sysroleWrapper.setEntity(sysrole);
        List<SysRole> sysroles = sysroleDao.selectList(sysroleWrapper);
        resData.setData("sysroles", sysroles);
        log.info("###[服务] 完成查询角色信息 ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData listPager(SysRole sysrole, Pager page) throws Exception {
        log.debug("###[服务] 开始根据条件{}分页查询角色信息", sysrole);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        Page<SysRole> pageParam = new Page<>(page.getCurrentPage(), page.getTotalSize()); // 当前页码，每页条数
        QueryWrapper<SysRole> sysroleWrapper = new QueryWrapper<>();
        sysroleWrapper.setEntity(sysrole);
        IPage<SysRole> pu = sysroleDao.selectPage(pageParam, sysroleWrapper);
        resData.setData("data", pu);

        log.info("###[服务] 完成分页查询角色信息 resData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData add(SysRole sysrole) throws Exception {
        log.debug("###[服务] 开始添加新角色信息, {}", sysrole);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        sysrole.setCreateby(SecurityUtils.getUsername());
        int inserted = sysroleDao.insert(sysrole);
        boolean b = insertRoleMenu(sysrole);
        if (inserted == 1 && b) {
            resData.setData("inserted", true);
        } else {
            resData.setData("inserted", false);
        }
        log.info("###[服务] 完成添加新角色信息，ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData update(SysRole sysrole) throws Exception {
        log.debug("###[服务] 开始根据条件{}修改角色信息,", sysrole);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        sysrole.setUpdateby(SecurityUtils.getUsername());
        int updated = sysroleDao.updateById(sysrole);
        Map<String, Object> map = new HashMap<>();
        map.put("roleid", sysrole.getRoleid());
        roleMenuService.removeByMap(map);
        boolean b = insertRoleMenu(sysrole);
        if (updated == 1 && b) {
            resData.setData("updated", true);
        } else {
            resData.setData("updated", false);
        }
        log.info("###[服务] 完成修改角色信息，ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData delete(String roleid) throws Exception {
        log.debug("###[服务] 开始根据条件{}删除角色信息,", roleid);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        SysRole sysrole = new SysRole();
        sysrole.setRoleid(Long.valueOf(roleid));
        int deleted = sysroleDao.deleteById(sysrole);

        Map<String, Object> map = new HashMap<>();
        map.put("roleid", sysrole.getRoleid());
        roleMenuService.removeByMap(map);
        boolean b = insertRoleMenu(sysrole);
        if (deleted == 1 && b) {
            resData.setData("updated", true);
        } else {
            resData.setData("updated", false);
        }
        log.info("###[服务] 完成删除角色信息，ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        List<SysRole> perms = sysroleDao.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getRolekey().trim().split(",")));
            }
        }
        return permsSet;
    }

    @Override
    public List<SysRole> selectRoleAll() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        List<SysRole> sysRoles = sysroleDao.selectList(queryWrapper);
        return sysRoles;
    }

    @Override
    public void checkUserAllowed(SysUser user) {
        if (StringUtils.isNotNull(user.getUserid()) && user.isAdmin()) {
            throw new CustomException("不允许操作超级管理员用户");
        }
    }

    @Override
    public List<Integer> selectRoleListByUserId(Long userId) {
        return sysroleDao.selectRoleListByUserId(userId);
    }

    @Override
    public void checkRoleAllowed(SysRole role) {
        if (StringUtils.isNotNull(role.getRoleid()) && role.isAdmin()) {
            throw new CustomException("不允许操作超级管理员角色");
        }
    }

    /**
     * 修改角色状态
     *
     * @param sysrole 角色信息
     * @return 结果
     */
    @Override
    public ResultData updateRoleStatus(SysRole sysrole) {
        log.debug("###[服务] 开始根据条件{}修改角色状态,sysrole=[{}]", sysrole);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        sysrole.setUpdateby(SecurityUtils.getUsername());
        int updated = sysroleDao.updateById(sysrole);
        resData.setData("updated", updated == 0 ? false : true);
        log.info("###[服务] 完成修改角色状态，ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData deleteByIds(Long[] roleIds) {

        log.debug("###[服务] 开始批量删除角色,roleIds=[{}]", roleIds);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        Collection<Long> ide = Arrays.asList(roleIds);
        int delete = sysroleDao.deleteBatchIds(ide);
        for (Long roleId : roleIds) {
            Map<String, Object> map = new HashMap<>();
            map.put("roleid", roleId);
            roleMenuService.removeByMap(map);
        }

        resData.setData("delete", delete == 0 ? false : true);
        log.info("###[服务] 完成修改角色状态，ResultData=[{}]", resData);
        return resData;
    }

    //---------------内部方法--------------------------------------

    /**
     * 新增角色菜单信息
     *
     * @param role 角色对象
     */
    public boolean insertRoleMenu(SysRole role) {
        int rows = 1;
        // 新增用户与角色管理
        List<SysRoleMenu> list = new ArrayList<SysRoleMenu>();
        for (Long menuId : role.getMenuIds()) {
            SysRoleMenu rm = new SysRoleMenu();
            rm.setRoleid(role.getRoleid());
            rm.setMenuid(menuId);
            list.add(rm);
        }
        boolean b = false;
        if (list.size() > 0) {
            Collection<SysRoleMenu> collection1 = list;
            b = roleMenuService.saveBatch(collection1);
        }
        return b;
    }
}
