package cn.com.taiji.secuirty.securityday1.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("My first custom WebSecurityConfig class");
//
//        // 1. 确定URL范围：
//        // 1. URL 拦截注册器
//        ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry
//                urlRegistry = http.requestMatchers()
////                .antMatchers("/a","/b","/c")
//                .antMatchers("/**")
//                .and()
//                .authorizeRequests();
//
////        http.antMatcher("/**").authorizeRequests();
////        http.authorizeRequests();
//
//        // 2，配置认证方式
//        ExpressionUrlAuthorizationConfigurer.AuthorizedUrl authorizedUrl =
//                (ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)urlRegistry.anyRequest();
//        authorizedUrl.authenticated();
//
//        // n.
//        FormLoginConfigurer<HttpSecurity> formLoginConfigurer = http.formLogin();
//        formLoginConfigurer.loginPage("/myLogin.html");
//        formLoginConfigurer.permitAll();


        http.authorizeRequests()
                .antMatchers("/error").permitAll()
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/myLogin").permitAll()
                .successHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write("{'error_code':'0', 'message':'欢迎登录系统'}");
                }).failureHandler((request, response, exception) -> {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(401);
            response.getWriter().write(
                    "{'error_code':'401', 'message':'" + exception.getMessage() + "'}");
        }).passwordParameter("pass");
//                .successForwardUrl("/success");
//                .and()
//                .httpBasic();
        http.csrf().disable();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        String password = passwordEncoder().encode("1");

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").
                password(password).roles("USER")
                .build());
        manager.createUser(User.withUsername("admin").
                password(password).roles("ADMIN")
                .build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}