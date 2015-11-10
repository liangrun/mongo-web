package com.mongo.web.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractRepository<T,Q extends Serializable> {

	List<T> getAllObjects();
	void saveObject(T object);
	T getObject(String id);
	/*
	WriteResult updateObject(String id,String name);
	*/
	void deleteObject(String id);
	void createCollection();
	void dropCollection();

}
