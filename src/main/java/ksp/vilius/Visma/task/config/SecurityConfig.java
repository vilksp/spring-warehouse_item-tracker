package ksp.vilius.Visma.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static ksp.vilius.Visma.task.config.ApplicationUserRole.*;
import static org.springframework.http.HttpMethod.GET;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final static String LOGIN_URL = "/api/v1/user/**";
    private final static String WAREHOUSE_URL = "/api/v1/products";
    private final static String WAREHOUSE2_URL = "/api/v1/products/**";
    private final static String ADMIN_URL = "/api/v1/**";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", LOGIN_URL).permitAll()
                .antMatchers(ADMIN_URL).hasRole(ADMIN.name())
                .antMatchers(WAREHOUSE_URL, WAREHOUSE2_URL).hasAnyRole(MANAGER.name(), ADMIN.name())
                .antMatchers(GET, WAREHOUSE_URL, WAREHOUSE2_URL).hasRole(WAREHOUSE.name())
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails anna = User.builder()
                .username("anna")
                .password(passwordEncoder().encode("password"))
                .roles(WAREHOUSE.name())
                .authorities(WAREHOUSE.getGrantedAuthorities())
                .build();

        UserDetails linda = User.builder()
                .username("linda")
                .password(passwordEncoder().encode("password"))
                .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails tom = User.builder()
                .username("tom")
                .password(passwordEncoder().encode("password"))
                .roles(MANAGER.name())
                .authorities(MANAGER.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(anna, linda, tom);
    }
}
