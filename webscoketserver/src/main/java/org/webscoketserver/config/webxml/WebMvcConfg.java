package org.webscoketserver.config.webxml;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class WebMvcConfg implements WebMvcConfigurer{

	 @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) { 
	    registry.addResourceHandler("/app/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/",ResourceUtils.CLASSPATH_URL_PREFIX+"/image/"); 
	    registry.addResourceHandler("/view/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/view/",ResourceUtils.CLASSPATH_URL_PREFIX+"/image/"); 
	    registry.addResourceHandler("/favicon.ico").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/favicon.ico"); 
	 }
	 
	 /*  public void addCorsMappings(CorsRegistry registry) {
          registry.addMapping("/*").allowedOrigins("*");
          registry.addMapping("/view");
     }*/
	 
	 
	 
	 

}
