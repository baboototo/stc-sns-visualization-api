package com.stc.sns.visualization.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stc.sns.visualization.security.filters.FilterSkipMatcher;
import com.stc.sns.visualization.security.filters.FormLoginFilter;
import com.stc.sns.visualization.security.filters.JwtAuthenticationFilter;
import com.stc.sns.visualization.security.handlers.FormLoginAuthenticationSuccessHandler;
import com.stc.sns.visualization.security.handlers.JwtAuthenticationFailureHandler;
import com.stc.sns.visualization.security.jwt.HeaderTokenExtractor;
import com.stc.sns.visualization.security.providers.FormLoginAuthenticationProvider;
import com.stc.sns.visualization.security.providers.JwtAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FormLoginAuthenticationSuccessHandler formLoginAuthenticationSuccessHandler;

    @Autowired
    private FormLoginAuthenticationProvider formLoginAuthenticationProvider;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    private JwtAuthenticationFailureHandler jwtFailureHandler;

    @Autowired
    private HeaderTokenExtractor headerTokenExtractor;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public com.fasterxml.jackson.databind.ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    protected FormLoginFilter formLoginFilter() throws Exception {
        FormLoginFilter filter = new FormLoginFilter("/formlogin", formLoginAuthenticationSuccessHandler, null);
        filter.setAuthenticationManager(super.authenticationManagerBean());

        return filter;
    }

    protected JwtAuthenticationFilter jwtFilter() throws Exception {
        FilterSkipMatcher matcher = new FilterSkipMatcher(Arrays.asList("/formlogin"), "/api/**");
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter(matcher, jwtFailureHandler, headerTokenExtractor);
        filter.setAuthenticationManager(super.authenticationManagerBean());

        return filter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.formLoginAuthenticationProvider)
                .authenticationProvider(this.jwtAuthenticationProvider);
    }

    protected  void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .csrf().disable();

        http
                .headers().frameOptions().disable();

        http
                .addFilterBefore(formLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
