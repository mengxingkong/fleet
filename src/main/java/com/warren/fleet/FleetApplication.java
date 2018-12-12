package com.warren.fleet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan({"com.warren.fleet.mapper","com.warren.fleet.security.mapper"})
@SpringBootApplication
@ServletComponentScan
public class FleetApplication {
    public static void main(String[] args) {
        SpringApplication.run(FleetApplication.class, args);
    }
}
