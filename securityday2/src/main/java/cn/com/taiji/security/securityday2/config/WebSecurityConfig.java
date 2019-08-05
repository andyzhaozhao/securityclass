package cn.com.taiji.security.securityday2.config;

import cn.com.taiji.security.securityday2.extend.CustomUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder());

        // 不要加super.configure(auth)，因为有配置优先级问题，导致配置失败
//        super.configure(auth);
//        String password = passwordEncoder().encode("1");
//        auth.jdbcAuthentication().dataSource(dataSource);
//                .withUser("user").password(password).roles("USER")
//                .and().withUser("admin").password(password).roles("ADMIN");

        //auth.inMemoryAuthentication()
//                .withUser("user").password(password).roles("USER")
//                .and().withUser("admin").password(password).roles("ADMIN");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/css/**", "/images/**", "/js/**", "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("My Second custom WebSecurityConfig class");

        http.authorizeRequests()
                .antMatchers("/error").permitAll()
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().access("@customAuthService.canAccess(request,authentication)") //自定
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/myLogin").permitAll();
        http.csrf().disable();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        String password = passwordEncoder().encode("1");
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
//        manager.setDataSource(dataSource);
//
//       InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").
//                password(password).roles("USER")
//                .build());
//        manager.createUser(User.withUsername("admin").
//                password(password).roles("ADMIN")
//                .build());
//        return manager;
//    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}