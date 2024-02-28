package com.woozi.com.woozi.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.woozi.com.woozi.repository")
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(
            @Autowired DataSource dataSource,
            ApplicationContext applicationContext
    ) throws Exception {
    	SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
    	sqlSessionFactory.setDataSource(dataSource);
    	sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:mappers/**.xml"));
    	return sqlSessionFactory.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(
    		@Autowired SqlSessionFactory sqlSessionFactory
    		) {
    	return new SqlSessionTemplate(sqlSessionFactory);
    }
   
	
}
