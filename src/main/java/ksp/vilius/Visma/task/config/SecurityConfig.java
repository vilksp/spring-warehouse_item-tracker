package ksp.vilius.Visma.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/user/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/products", "/api/v1/products/**").hasRole(WAREHOUSE.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
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
                .build();

        UserDetails linda = User.builder()
                .username("linda")
                .password(passwordEncoder().encode("password123"))
                .roles(ADMIN.name())
                .build();

        UserDetails tom = User.builder()
                .username("tom")
                .password(passwordEncoder().encode("password123"))
                .roles(MANAGER.name())
                .build();

        return new InMemoryUserDetailsManager(anna, linda, tom);
    }
}
