package org.webscoketserver.config.webxml;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class FirstFilter implements Filter {

	private final List<String> allowedOrigins = Arrays.asList("http://localhost:9800");
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化过滤器");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = 	(HttpServletRequest)request ;
		System.out.println(httpRequest.getMethod()+":"+httpRequest.getServletPath());
		HttpServletResponse httpResponse = 	(HttpServletResponse)response ;
		String origin = httpRequest.getHeader("Origin");
		httpResponse.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
		httpResponse.setHeader("Vary", "Origin");
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		httpResponse.setHeader("Access-Control-Max-Age", "3600");
//		httpResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,sessionId,Cookie");
		httpResponse.setHeader("Access-Control-Allow-Headers", "*");
		httpResponse.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
