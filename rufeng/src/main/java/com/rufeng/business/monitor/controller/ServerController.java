package com.rufeng.business.monitor.controller;

import com.rufeng.core.framework.aspectj.lang.annotation.Log;
import com.rufeng.core.framework.web.ResultData;
import com.rufeng.core.framework.web.domain.Server;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务器监控
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/server")
public class ServerController {

    @RequestMapping(value = {}, method = RequestMethod.GET)
    public ResultData getInfo() throws Exception {
        ResultData data = ResultData.init();
        Server server = new Server();
        server.copyTo();
        data.setData("serverinfo", server);
        return data;
    }
}
