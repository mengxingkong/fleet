package com.warren.fleet.flowable.config;


import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class FlowableConfigration {

    @Autowired
    @Qualifier("flowableDataSource")
    private DataSource dataSource;


//    @Bean
//    public SpringProcessEngineConfiguration springProcessEngineConfiguration() {
//        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
//        springProcessEngineConfiguration.setDataSource(dataSource);
//        springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
//        return springProcessEngineConfiguration;
//    }

//    @Bean
//    @Primary
//    protected ProcessEngineConfiguration configuration() {
//        ProcessEngineConfiguration processEngineConfiguration = StandaloneProcessEngineConfiguration
//                .createStandaloneProcessEngineConfiguration()
//                .setDataSource(dataSource);
//        return processEngineConfiguration;
//    }
//
//    @Bean
//    protected ProcessEngine engine() {
//        //创建流程引擎  服务启动是初始化一次即可
//        return ProcessEngines.getDefaultProcessEngine();
//    }

}
