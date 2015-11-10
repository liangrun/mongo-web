package com.mongo.web.dao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Configuration
@ComponentScan
@EnableJpaRepositories("")
@PropertySource(value = {"classpath:config.properties"})
public class MongoConfig extends AbstractMongoConfiguration{

	@Value("${mango.db.name}")
	private String dbName;
	
	@Value("${mango.db.host}")
	private String dbHost;
	
	@Value("${mango.db.port}")
	private int dbPort;
	
	@Value("${mango.db.username}")
	private String dbUsername;
	
	@Value("${mango.db.password}")
	private String dbPassword;
	
	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public Mongo mongo() throws Exception {
		ServerAddress serverAddress = new ServerAddress(dbHost, dbPort);
		MongoCredential credential = MongoCredential.createMongoCRCredential(dbUsername, dbName, dbPassword.toCharArray());
		Mongo mongo = new MongoClient(serverAddress,Arrays.asList(credential));
		mongo.setWriteConcern(WriteConcern.SAFE);
		return mongo;
	}
	
}
