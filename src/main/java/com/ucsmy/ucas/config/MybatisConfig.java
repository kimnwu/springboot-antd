package com.ucsmy.ucas.config;

import com.ucsmy.commons.interceptor.MybatisLogInterceptor;
import com.ucsmy.commons.interceptor.MybatisPageInterceptor;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Mybatis配置
 * Created by ucs_zhongtingyuan on 2017/4/10.
 */
@Configuration
public class MybatisConfig {

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource, MybatisProperties properties) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        // 分页拦截器
        MybatisPageInterceptor interceptor = new MybatisPageInterceptor();
        // 日志拦截器
        MybatisLogInterceptor logInterceptor = new MybatisLogInterceptor();
        bean.setPlugins(new Interceptor[] { interceptor, logInterceptor });

        bean.setMapperLocations(properties.resolveMapperLocations());
        return bean.getObject();
    }

    @Bean
    public MapperScannerConfigurer configurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setAnnotationClass(Repository.class);
        configurer.setBasePackage("com.ucsmy");
        return configurer;
    }
}
