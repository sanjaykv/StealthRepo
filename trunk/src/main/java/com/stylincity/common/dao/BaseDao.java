package com.stylincity.common.dao;

import com.stylincity.common.exception.DBException;

public interface BaseDao<T> {
	T save(T entity);
	void update(T entity);
}