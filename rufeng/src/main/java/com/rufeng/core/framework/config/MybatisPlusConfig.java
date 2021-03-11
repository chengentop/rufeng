package com.rufeng.core.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@Configuration
@MapperScan(value = {"com.rufeng.business.*.mapper","com.rufeng.business.*.*.mapper"})
public class MybatisPlusConfig {

	@Autowired
	private Environment env;
	
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        //设置方言类型
        page.setDialectType(env.getProperty("spring.datasource.dbtype"));
        return page;
    }
}