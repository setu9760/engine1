package com.mycompany.engine1;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("com.mycompany.app.common.repository")
public class Config {

	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
}
