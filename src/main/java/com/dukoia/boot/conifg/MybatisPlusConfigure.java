package com.dukoia.boot.conifg;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @Description: MybatisPlusConfigure
 * @Author: jiangze.He
 * @Date: 2021-06-11
 * @Version: v1.0
 */
@MapperScan("com.dukoia.boot.mapper")
@Configuration(proxyBeanMethods = false)
public class MybatisPlusConfigure {

    /**
     * 注册分页插件
     */
    @Bean
    @Order(-2)
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}
