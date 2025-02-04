package com.kdk.config.app;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

/**
 * <pre>
 * -----------------------------------
 * 개정이력
 * -----------------------------------
 * 2025. 2. 4. kdk	최초작성
 * </pre>
 *
 *
 * @author kdk
 */
@EnableTransactionManagement
@Configuration
public class TransactionConfig {

    @Bean
    PlatformTransactionManager transactionManager(DataSource dataSource) {
    	DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        transactionManager.setDefaultTimeout(30);
		return transactionManager;
	}

	@Bean
	PlatformTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
        transactionManager.setDefaultTimeout(30);
		return transactionManager;
	}

}
