package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mybatis")
@Component(value = "myBatisProperties")
public class MyBatisProperties {

    private String typeAliasesPackage;

    private String configLocation;

    private String mapperLocations;

    private String basePackage;

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    @Override
    public String toString() {
        return "MyBatisProperties{" +
                "typeAliasesPackage='" + typeAliasesPackage + '\'' +
                ", configLocation='" + configLocation + '\'' +
                ", mapperLocations='" + mapperLocations + '\'' +
                ", basePackage='" + basePackage + '\'' +
                '}';
    }
}
