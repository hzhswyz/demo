package com.hzh.demo.config;

import com.hzh.demo.encryption.SSPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("user").password("12345").roles("user")
               // .and().withUser("admin").password("admin").roles("admin","user");
        auth.jdbcAuthentication().dataSource(dataSource).
                usersByUsernameQuery("select name,password,locking from user where name=?")
                .authoritiesByUsernameQuery("select name,auth from user where name=?")
                .passwordEncoder(new SSPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().
                loginPage("/login").
             //and().
               // httpBasic().realmName("/").
             and().
                logout().
                logoutSuccessUrl("/").
             and().
                authorizeRequests().
                antMatchers("/thymeleaf/test").hasRole("admin").
                antMatchers(HttpMethod.POST, "/thymeleaf/post").authenticated().
                anyRequest().anonymous().
                anyRequest().permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().
                antMatchers("/resources/**");
    }

}
