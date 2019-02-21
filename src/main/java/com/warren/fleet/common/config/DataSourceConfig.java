package com.warren.fleet.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Primary
    @Bean(name = "flowableDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.flowable")
    public DataSource flowableDataSource(){
        return DataSourceBuilder.create().build();
    }
}
