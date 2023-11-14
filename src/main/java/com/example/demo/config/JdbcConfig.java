package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class JdbcConfig {

	@Bean(name = "jdbcSourceAulaUm")
	public DataSource dataSource() {
		DataSourceBuilder dataSource = DataSourceBuilder.create();
		dataSource.driverClassName("org.postgresql.Driver");
		dataSource.url("jdbc:postgresql://localhost:5432/jdbcaulaum");
		dataSource.username("postgres");
		dataSource.password("renan123");
		return dataSource.build();
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
