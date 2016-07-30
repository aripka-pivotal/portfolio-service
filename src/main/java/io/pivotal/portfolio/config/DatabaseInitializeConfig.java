package io.pivotal.portfolio.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DatabaseInitializeConfig {
	@Autowired
	DataSource dataSource;
	
	@Bean
	public String initDb(){
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(
				new ClassPathResource("data/sampledata.sql"));
		databasePopulator.setContinueOnError(true);
		System.out.println(dataSource.getClass().getName());
		
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
		return "done";
	}
	
}
