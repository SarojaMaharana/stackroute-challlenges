package com.stackroute.newz.jwtfilter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

/* This class implements the custom filter by extending org.springframework.web.filter.GenericFilterBean.  
 * Override the doFilter method with ServletRequest, ServletResponse and FilterChain.
 * This is used to authorize the API access for the application.
 */

public class JwtFilter extends GenericFilterBean {

		/*
	 * Override the doFilter method of GenericFilterBean.
     * Retrieve the "authorization" header from the HttpServletRequest object.
     * Retrieve the "Bearer" token from "authorization" header.
     * If authorization header is invalid, throw Exception with message. 
     * Parse the JWT token and get claims from the token using the secret key
     * Set the request attribute with the retrieved claims
     * Call FilterChain object's doFilter() method */
	
	
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest servletRequest = (HttpServletRequest) request;
		final HttpServletResponse servletResponse = (HttpServletResponse) response;

		final String authHeader = servletRequest.getHeader("Authorization");

		if(servletRequest.getMethod().equals("OPTIONS")) {
			servletResponse.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(servletRequest,servletResponse);
		} else if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			throw new ServletException("Missing or invalid token");
		}

		String token = authHeader.substring(7);

		Claims claims = Jwts.parser().setSigningKey("newzSecret").parseClaimsJws(token).getBody();
		servletRequest.setAttribute("claims", claims);
		chain.doFilter(servletRequest,servletResponse);
	}

}

