package com.istad.springsecuritybasic.cofiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {
    // configuration for the security
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity  httpSecurity) throws  Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/homepage","/feed","/email/**")
                .permitAll()
                .requestMatchers("/user/**")
                .hasRole("USER")
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();


     return httpSecurity.build();
    }

    // in memory is mainly for testing
    // H2 -> in memory
//    @Bean
//    public InMemoryUserDetailsManager userDetailService(){
//        UserDetails user1 = User.withUsername("james")
//                .password("12345")
//                .roles("USER")
//                .build();
//
//        UserDetails user2  = User.withUsername("Jiva")
//                .password("54321")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }




    // password encoder
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @SuppressWarnings("deprecation")
    @Bean
    public NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


}
