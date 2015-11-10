package com.mongo.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mongo.web.dao.DaoConfig;
import com.mongo.web.service.ServiceConfig;

@Configuration
@Import({DaoConfig.class,ServiceConfig.class})
public class AppConfig {

}
