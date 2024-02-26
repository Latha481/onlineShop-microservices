package com.onlineShop.microservices.apiGateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity(debug = true)
public class Securityconfig {


//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((requests)->requests
//                        .requestMatchers("/test").authenticated()
//                        .requestMatchers("/verifying","/checkingg").permitAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }


//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        System.out.println("HHDGXKDWHJCDKHWJCDKWJ");
//        http.csrf((csrf) -> csrf.disable())
//                .securityMatcher("/testAdmin","/postTestAdmin","/test")
//                .authorizeHttpRequests((requests)->requests
//                        .requestMatchers("/testAdmin","/postTestAdmin","/test").permitAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();


        private static final String[] AUTH_WHITELIST = {
                "/test"
        };
//        @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            http.csrf(AbstractHttpConfigurer::disable)
//                    .authorizeHttpRequests((authorize) -> authorize
//                            .requestMatchers(AUTH_WHITELIST).permitAll()
//                            .requestMatchers("/error").permitAll()
//                            .anyRequest().authenticated()
//                    )
//                    .formLogin(Customizer.withDefaults())
//                    .httpBasic(Customizer.withDefaults());
//            return http.build();
//        }


    }


