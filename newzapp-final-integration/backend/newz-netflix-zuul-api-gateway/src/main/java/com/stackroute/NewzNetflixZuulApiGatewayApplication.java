package com.stackroute;

import com.stackroute.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class NewzNetflixZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewzNetflixZuulApiGatewayApplication.class, args);
	}

	/*
	 * Define the bean for Filter registration. Create a new FilterRegistrationBean
	 * object and use setFilter() method to set new instance of JwtFilter object.
	 * Also specifies the Url patterns for registration bean.
	 */


	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new JwtFilter());
		filter.addUrlPatterns("/newsservice/api/v1/news/*");
		filter.addUrlPatterns("/newssourceservice/api/v1/newssource/*");
		filter.addUrlPatterns("/userprofileservice/api/v1/userprofile/*");
		return filter;
	}

}
