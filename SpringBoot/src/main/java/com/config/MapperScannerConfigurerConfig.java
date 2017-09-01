package com.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MapperScannerConfigurerConfig {

    public static final String backPackage = "com.myself.persistences.mapper";

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        final MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(backPackage);
        return mapperScannerConfigurer;
    }

}
