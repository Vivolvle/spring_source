package com.vivolvle.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Profile:
 *      Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 * 开发环境，测试环境，生产环境
 * 数据源
 * @author weilz
 * @date 2019/10/22
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile {
    @Value("${db.name}")
    private String user;

    @Bean
    public DataSource dataSourceTest(@Value("${db.password}") String pwd){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(pwd);
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://106.12.27.130:3306/caffeine");
        return druidDataSource;
    }

    @Bean
    public DataSource dataSourceDev(@Value("${db.password}") String pwd){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(pwd);
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://106.12.27.130:3306/caffeine");
        return druidDataSource;
    }

    @Bean
    public DataSource dataSourceProd(@Value("${db.password}") String pwd){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(pwd);
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://106.12.27.130:3306/caffeine");
        return druidDataSource;
    }


}
