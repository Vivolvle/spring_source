package com.vivolvle.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Profile:
 *      Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 * 开发环境，测试环境，生产环境
 * 数据源
 * 1:加了环境标示的bean，只有环境被激活了（标了default的除外），才可以被加载
 *  -Dspring.profiles.active=test
 *  2：还可以写在类上
 * @author weilz
 * @date 2019/10/22
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
    @Value("${db.name}")
    private String user;

    private StringValueResolver stringValueResolver;

    private String driverClass;

    @Profile("test")
    @Bean
    public DataSource dataSourceTest(@Value("${db.password}") String pwd){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(pwd);
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl("jdbc:mysql://106.12.27.130:3306/caffeine");
        return druidDataSource;
    }

    @Profile("dev")
    @Bean
    public DataSource dataSourceDev(@Value("${db.password}") String pwd){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(pwd);
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl("jdbc:mysql://106.12.27.130:3306/caffeine");
        return druidDataSource;
    }

    @Profile("prod")
    @Bean
    public DataSource dataSourceProd(@Value("${db.password}") String pwd){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(pwd);
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl("jdbc:mysql://106.12.27.130:3306/caffeine");
        return druidDataSource;
    }


    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
        this.driverClass = stringValueResolver.resolveStringValue("${db.driver-class-name}");
    }
}
