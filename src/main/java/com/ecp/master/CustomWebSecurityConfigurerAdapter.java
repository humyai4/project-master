//package com.ecp.master;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//
//import javax.sql.DataSource;
//
//@EnableWebSecurity
//@Configuration
//public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Override
//    protected void
//    configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("root")
//                .password(passwordEncoder().encode("1234"))
//                .authorities("ADMIN");
//
//    }
//    @Bean
//    public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception{
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//        jdbcUserDetailsManager.setDataSource(dataSource);
//        return jdbcUserDetailsManager;
//    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }
//
//
//
//    @Override
//    protected  void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
////                .antMatchers("/user/userList").permitAll()
//                .antMatchers(HttpMethod.GET,"/user/userList").permitAll()
//                .antMatchers(HttpMethod.GET,"/news/newsList").permitAll()
//                .antMatchers(HttpMethod.POST,"/news/newsDelete").permitAll()
//                .antMatchers(HttpMethod.POST,"/news/newsCreate").permitAll()
//                .antMatchers(HttpMethod.POST,"/image/save").permitAll()
//                .antMatchers(HttpMethod.POST,"/user/register").permitAll()
//                .antMatchers(HttpMethod.POST,"/user/checkEmail").permitAll()
//                .antMatchers(HttpMethod.POST,"/news/newsUpdate").permitAll()
//                .antMatchers(HttpMethod.POST,"/*").permitAll()
//                .antMatchers(HttpMethod.POST,"/login").permitAll()
//
//                .anyRequest().authenticated();
//        http.csrf().disable();
//    }
//
//
//
//
//
//    @Autowired
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new
//                BCryptPasswordEncoder();
//    }
//
//}
