package com.mongo.web.dao;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Configuration
@ComponentScan
@EnableJpaRepositories("com.mongo.web.dao.*")
@PropertySource(value = {"classpath:mongo.config.properties"})
public class MongoConfig extends AbstractMongoConfiguration{

	private static final Logger logger = LoggerFactory.getLogger(MongoConfig.class);
	//@Value("${mongo.db.name}")
	@Value("user")
	private String dbName;
	
	//@Value("${mongo.db.host}")
	@Value("127.0.0.1")
	private String dbHost;
	
	//@Value("${mongo.db.port}")
	@Value("27017")
	private int dbPort;
	
	//@Value("${mongo.db.username}")
	@Value("test")
	private String dbUsername;
	
	//@Value("${mongo.db.password}")
	@Value("")
	private String dbPassword;
	
	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public Mongo mongo() throws Exception {
		logger.info("MongoConfig-->mongo");
		ServerAddress serverAddress = new ServerAddress(dbHost, dbPort);
		MongoCredential credential = MongoCredential.createMongoCRCredential(dbUsername, dbName, dbPassword.toCharArray());
		Mongo mongo = new MongoClient(serverAddress,Arrays.asList(credential));
		mongo.setWriteConcern(WriteConcern.SAFE);
		return mongo;
	}
	
}
