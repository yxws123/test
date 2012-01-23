package com.kline.core.service;

public interface BaseNameEntityService {

	public <T> T insert(T obj);

	public int update(Object obj);

	public <T> T getById(String name);

//	public int delete(Object obj);

	public int deleteById(String name);
}
