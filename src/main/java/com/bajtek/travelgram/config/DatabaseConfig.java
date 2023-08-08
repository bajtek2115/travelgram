package com.bajtek.travelgram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    public class SpringJdbcConfig {

        @Bean
        public DataSource mySQLDataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/travelgram");
            dataSource.setUsername("bajtek");
            dataSource.setPassword("1234");
            return dataSource;
        }

    }
}