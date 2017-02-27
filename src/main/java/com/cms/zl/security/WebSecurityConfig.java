package com.cms.zl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Created by Vincent on 2016/12/23.
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    private final BasedUserDetailsServiceImpl userDetailsService;

    @Autowired
    public WebSecurityConfig(BasedUserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/upload/articleImages/**").addResourceLocations("classpath:/upload/articleImages/");
//    }

    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/resources/**");//忽略任何以"resources"开头的请求
        webSecurity.ignoring().antMatchers("/css/**","/images/**","/js/**");
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .anyRequest().permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and().formLogin().loginPage("/signin").defaultSuccessUrl("/blog/index")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/blog/index")
                .and().rememberMe().rememberMeParameter("remember-me").tokenValiditySeconds(3153600)
                .and().csrf().disable();
//                .anyRequest().authenticated()
//                .antMatchers("/signup", "/signin").permitAll() //允许任何人访问"signup"和"signin"
//                .antMatchers("/admin/**").hasRole("ADMIN")  //访问以"admin"开头的地址，必须具有ROLE_ADMIN身份
//                .and().formLogin().loginPage("/signin").permitAll()
//                .and().logout().permitAll()
//                .and().rememberMe().rememberMeParameter("remember-me")
//                .and().csrf().disable();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
