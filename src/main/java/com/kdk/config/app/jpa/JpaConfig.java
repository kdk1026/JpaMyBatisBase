package com.kdk.config.app.jpa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

/**
 * <pre>
 * -----------------------------------
 * 개정이력
 * -----------------------------------
 * 2025. 2. 1. kdk	최초작성
 * </pre>
 *
 *
 * @author kdk
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.kdk.app.jpa.repository",
	    entityManagerFactoryRef = "entityManagerFactory",
	    transactionManagerRef = "jpaTransactionManager"
)
public class JpaConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(dataSource)
            .packages("com.kdk.app.jpa.entity")
            .persistenceUnit("primary")
            .build();
    }

	@Bean
	PlatformTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
        transactionManager.setDefaultTimeout(30);
		return transactionManager;
	}

}
