package com.kline.core.service;

public interface BaseIdEntityService {

	public <T> T insert(T obj);

	public int update(Object obj);

	public <T> T getById(long id);

//	public int delete(Object obj);

	public int deleteById(long id);
}
