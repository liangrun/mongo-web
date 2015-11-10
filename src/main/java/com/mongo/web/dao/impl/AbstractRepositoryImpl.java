package com.mongo.web.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongo.web.dao.AbstractRepository;

@Repository
public class AbstractRepositoryImpl<T,Q extends Serializable> implements AbstractRepository<T,Q>{
	
	@Inject
	private ApplicationContext applicationContext;
	
	private final Class<T> bean;
	
	@SuppressWarnings("unchecked")
	protected  AbstractRepositoryImpl() {
		//set bean
		bean = (Class<T>) String.class;
	}
	
	/*private MongoDbFactory mongoDbFactory;
	
	protected MongoDbFactory createMongoDbFactory() {
		return applicationContext.getBean(MongoDbFactory.class);
	}
	
	private synchronized MongoDbFactory getMongoDbFactory() {
		if (mongoDbFactory == null) {
			mongoDbFactory = createMongoDbFactory();
		}
		return mongoDbFactory;
	}
	*/
	
	protected synchronized MongoTemplate getMongoTemplate() {
		return applicationContext.getBean(MongoTemplate.class) ;
	}
	public List<T> getAllObjects() {
		// TODO Auto-generated method stub
		return getMongoTemplate().findAll(bean);
	}

	public void saveObject(T object) {
		// TODO Auto-generated method stub
		getMongoTemplate().insert(object);
	}

	public T getObject(String id) {
		// TODO Auto-generated method stub
		return getMongoTemplate().findById(id, bean);
	}

	public void deleteObject(String id) {
		// TODO Auto-generated method stub
		getMongoTemplate().remove(getObject(id));
	}

	public void createCollection() {
		// TODO Auto-generated method stub
		if (!getMongoTemplate().collectionExists(bean)) {
			getMongoTemplate().createCollection(bean);
		}
	}

	public void dropCollection() {
		// TODO Auto-generated method stub
		if (getMongoTemplate().collectionExists(bean)) {
			getMongoTemplate().dropCollection(bean);
		}
	}

}
