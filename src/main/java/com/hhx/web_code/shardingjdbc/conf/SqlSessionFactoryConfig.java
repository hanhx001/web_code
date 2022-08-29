package com.hhx.web_code.shardingjdbc.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author gxz
 * @date 2020/10/23 13:54
 */
@Configuration
@Order(3)
public class SqlSessionFactoryConfig {


    @Bean
    public SqlSessionFactory shardingSessionFactory(
            @Qualifier("shardingDataSource") DataSource shardingDataSource) throws Exception {
      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
      sqlSessionFactoryBean.setDataSource(shardingDataSource);
      ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
      sqlSessionFactoryBean.setMapperLocations(
              resolver.getResources("classpath*:mapper/*.xml"));
      sqlSessionFactoryBean.setConfigLocation(
              resolver.getResource("classpath:mybatis/mybatis-config.xml"));

      return sqlSessionFactoryBean.getObject();
    }



}
