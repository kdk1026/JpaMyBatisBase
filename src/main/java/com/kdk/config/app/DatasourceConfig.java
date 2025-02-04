package com.kdk.config.app;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * <pre>
 * -----------------------------------
 * 개정이력
 * -----------------------------------
 * 2024. 6. 8. 김대광	최초작성
 * </pre>
 *
 *
 * @author 김대광
 */
@Configuration
public class DatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    HikariConfig hikariConfig() {
		return new HikariConfig();
	}

    @Bean
    DataSource dataSource() {
		return new HikariDataSource(this.hikariConfig());
	}

}
