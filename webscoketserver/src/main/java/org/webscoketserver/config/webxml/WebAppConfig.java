package org.webscoketserver.config.webxml;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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