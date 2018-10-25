package org.webscoketserver.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.webscoketserver.config.webxml.FirstFilter;

/**
 * 过滤器配置
 * 
 * @author wangjiping
 *
 */
@Configuration
public class WebAppConfig {

	/**
	 * 配置过滤器
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<FirstFilter> someFilterRegistration() {
		FilterRegistrationBean<FirstFilter> registration = new FilterRegistrationBean<FirstFilter>();
		registration.setFilter(new FirstFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("cors");
		return registration;
	}


}