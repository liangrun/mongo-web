package com.mongo.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mongo.web.controller.ControllerConfig;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.mongo.web.*")
@Import({AppConfig.class,ControllerConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter{
	private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);
	@Bean
	public ViewResolver getViewResolver() {
		logger.info("WebConfig --> getViewResolver");
		final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("WebConfig --> addResourceHandlers");
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("/bootstrap/");
		registry.addResourceHandler("/jquery/**").addResourceLocations("/jquery/");
		registry.addResourceHandler("/staticres/**").addResourceLocations("/staticres/");
		registry.addResourceHandler("/IE8lower/**").addResourceLocations("/IE8lower/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}
}
