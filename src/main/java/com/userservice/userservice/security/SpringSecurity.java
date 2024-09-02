package com.userservice.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {
    @Bean
    public SecurityFilterChain filteringCriteria(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authorize-> authorize.anyRequest().permitAll());
//        http.authorizeHttpRequests(authorize-> authorize.requestMatchers("/auth/home").authenticated());
        return http.build();
    }
//
//@Bean
//public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.cors().and().csrf().disable()
//            .exceptionHandling().authenticationEntryPoint(jwtEntryPoint).and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//            .authorizeHttpRequests()
//    http.requestMatchers("/**").permitAll()
//            .anyRequest().authenticated();
//    http.addFilterBefore(jwtTokenFilter()
//            , UsernamePasswordAuthenticationFilter.class);

//    return http.build();
//}
    @Bean

    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
