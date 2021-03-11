package com.rufeng.business.system.service.impl;


import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rufeng.core.utils.DictUtils;
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
import com.rufeng.business.system.service.ISysDictDataService;
import com.rufeng.business.system.mapper.ISysDictDataDao;
import com.rufeng.business.system.domain.po.SysDictData;


/**
 * 字典数据 服务接口实现
 *
 * @version v1.0.0
 * @since jdk1.8+
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<ISysDictDataDao, SysDictData> implements ISysDictDataService {
    private Logger log = LoggerFactory.getLogger(SysDictDataServiceImpl.class);

    @Autowired
    private ISysDictDataDao sysdictdataDao;

    @Override
    public ResultData get(String dictcode) throws Exception {
        log.debug("###[服务] 开始查询字典数据 dictcode=[{}]. ", dictcode);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        SysDictData sysdictdata = sysdictdataDao.selectById(dictcode);
        resData.setData("sysdictdata", sysdictdata);
        log.info("###[服务] 完成查询字典数据 ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData list(SysDictData sysdictdata) throws Exception {
        log.debug("###[服务] 开始根据条件{}查询字典数据", sysdictdata);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        QueryWrapper<SysDictData> sysdictdataWrapper = new QueryWrapper<>();
        sysdictdataWrapper.setEntity(sysdictdata);
        List<SysDictData> sysdictdatas = sysdictdataDao.selectList(sysdictdataWrapper);
        resData.setData("sysdictdatas", sysdictdatas);
        log.info("###[服务] 完成查询字典数据 ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData listPager(SysDictData sysdictdata, Pager page) throws Exception {
        log.debug("###[服务] 开始根据条件{}分页查询字典数据", sysdictdata);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        Page<SysDictData> pageParam = new Page<>(page.getCurrentPage(), page.getTotalSize()); // 当前页码，每页条数
        QueryWrapper<SysDictData> sysdictdataWrapper = new QueryWrapper<>();
        sysdictdataWrapper.setEntity(sysdictdata);
        IPage<SysDictData> pu = sysdictdataDao.selectPage(pageParam, sysdictdataWrapper);
        resData.setData("data", pu);

        log.info("###[服务] 完成分页查询字典数据 resData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData add(SysDictData sysdictdata) throws Exception {
        log.debug("###[服务] 开始添加新字典数据, {}", sysdictdata);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        int inserted = sysdictdataDao.insert(sysdictdata);
        resData.setData("inserted", inserted);
        log.info("###[服务] 完成添加新字典数据，ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData update(SysDictData sysdictdata) throws Exception {
        log.debug("###[服务] 开始根据条件{}修改字典数据,", sysdictdata);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        int updated = sysdictdataDao.updateById(sysdictdata);
        resData.setData("updated", updated);
        log.info("###[服务] 完成修改字典数据，ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData delete(String dictcode) throws Exception {
        log.debug("###[服务] 开始根据条件{}删除字典数据,", dictcode);
        //These code is generated by machine, if you want to modify the code, suggest you to remove this line
        ResultData resData = ResultData.init();
        SysDictData sysdictdata = new SysDictData();
        sysdictdata.setDictcode(Long.valueOf(dictcode));
        int deleted = sysdictdataDao.deleteById(sysdictdata);
        resData.setData("deleted", deleted);
        log.info("###[服务] 完成删除字典数据，ResultData=[{}]", resData);
        return resData;
    }

    @Override
    public ResultData selectDictDataByType(String dictType) {
        log.debug("###[服务] 开始根据条件{}删除字典数据,", dictType);
        ResultData resData = ResultData.init();
        List<SysDictData> dictDatas = DictUtils.getDictCache(dictType);
        if (StringUtils.isNotNull(dictDatas)) {
            resData.setData("dictDatas", dictDatas);
            return resData;
        }
        dictDatas = sysdictdataDao.selectDictDataByType(dictType);
        if (StringUtils.isNotNull(dictDatas)) {
            DictUtils.setDictCache(dictType, dictDatas);
            resData.setData("dictDatas", dictDatas);
            return resData;
        }
        log.info("###[服务] 完成删除字典数据，ResultData=[{}]", resData);
        return resData;
    }
}
