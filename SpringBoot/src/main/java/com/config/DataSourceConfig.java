package com.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import com.alibaba.druid.pool.xa.DruidXADataSource;

@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {
	
	protected static final String PACKAGE = "com.myself.persistences.mapper";
	
	private static final String MAPPER_LOCATION = "classpath:/com/myself/persistences/mapper/../*Mapper.xml";
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String user;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean("druidXADataSource")
	@Primary
	public DataSource druidXADataSource() {
		DruidXADataSource dataSource = new DruidXADataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean("dataSourceProxy")
	@Primary
	public TransactionAwareDataSourceProxy transactionAwareDataSourceProxy(@Qualifier("druidXADataSource") DataSource dataSource) {
		return new TransactionAwareDataSourceProxy(dataSource);
	}
	
	@Bean("transactionManager")
	@Primary
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSourceProxy") TransactionAwareDataSourceProxy dataSourceProxy) {
		return new DataSourceTransactionManager(dataSourceProxy);
	}
	
	@Bean("sqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceProxy") TransactionAwareDataSourceProxy dataSourceProxy) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSourceProxy);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConfig.MAPPER_LOCATION));
		sessionFactory.setTypeAliasesPackage("com.persistence.entity");
		return sessionFactory.getObject();
	}

}
