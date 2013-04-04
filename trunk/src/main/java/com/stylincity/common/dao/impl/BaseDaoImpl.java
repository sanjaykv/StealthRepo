package com.stylincity.common.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.stylincity.common.dao.BaseDao;
import com.stylincity.common.exception.DBException;

public class BaseDaoImpl<T> implements BaseDao<T> {	
	
	@PersistenceUnit(unitName = "STYLEDS")
	private EntityManagerFactory managerFactory;

	public void setManagerFactory(EntityManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	public EntityManagerFactory getManagerFactory() {
		return this.managerFactory;
	}

	public EntityManager getEntityManager() {
		return managerFactory.createEntityManager();
	}

	@Override
	public T save(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public void update(T entity) {
		this.getEntityManager().merge(entity);
	}
}