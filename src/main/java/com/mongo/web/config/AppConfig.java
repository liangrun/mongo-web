package com.mongo.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mongo.web.dao.DaoConfig;
import com.mongo.web.service.ServiceConfig;

@Configuration
@Import({ DaoConfig.class, ServiceConfig.class })
public class AppConfig {
	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
	public AppConfig() {
		logger.info("AppConfig");
	}
}
