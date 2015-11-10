package com.mongo.web.config;

import org.springframework.context.annotation.Bean;
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
@Import({AppConfig.class,ControllerConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter{
	@Bean
	public ViewResolver getViewResolver() {
		
		final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("/bootstrap/");
		registry.addResourceHandler("/jquery/**").addResourceLocations("/jquery/");
		registry.addResourceHandler("/staticres/**").addResourceLocations("/staticres/");
		registry.addResourceHandler("/IE8lower/**").addResourceLocations("/IE8lower/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}
}
