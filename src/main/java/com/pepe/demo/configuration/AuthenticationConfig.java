package com.pepe.demo.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/main/list", "/member/signin", "member/signup").permitAll() // 여러 개의 엔드포인트에 대해 인증 없이 접근 허용
                .antMatchers(HttpMethod.POST).authenticated()
                .and().csrf().disable();
    }

}
