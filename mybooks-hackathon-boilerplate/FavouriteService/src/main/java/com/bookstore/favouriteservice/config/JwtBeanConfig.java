package com.bookstore.favouriteservice.config;

import com.bookstore.favouriteservice.jwtfilter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtBeanConfig {
    @Bean
    public FilterRegistrationBean jwtFilterBean() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new JwtFilter());
        filter.addUrlPatterns("/api/v1/favourite/*");

        return filter;
    }

}
