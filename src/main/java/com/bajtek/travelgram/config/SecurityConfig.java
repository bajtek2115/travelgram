package com.bajtek.travelgram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService detailsService(DataSource dataSource, AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,enabled "
                        + "from user "
                        + "where username = ?")
                .authoritiesByUsernameQuery("select u.username,a.authority from authority a join user u on a.userId = u.id where u.username = ?");
        return new JdbcUserDetailsManager(dataSource);
    }

}

//.authoritiesByUsernameQuery("select email,authority "
//        + "from authorities "
//        + "where email = ?");