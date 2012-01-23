package com.kline.core.service.impl;

//import org.nutz.dao.Condition;
import org.nutz.service.NameEntityService;

import com.kline.core.service.BaseNameEntityService;

public abstract class BaseNameEntityServiceImpl<T> extends NameEntityService<T>
		implements BaseNameEntityService {

	@SuppressWarnings("hiding")
	@Override
	public <T> T insert(T obj) {
		// TODO Auto-generated method stub
		return this.dao().insert(obj);
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return this.dao().update(obj);
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> T getById(String name) {
		// TODO Auto-generated method stub
		return (T)this.fetch(name);
	}

//	@Override
//	public int delete(Object obj) {
//		// TODO Auto-generated method stub
//		return this.dao().delete(obj);
//	}

	@Override
	public int deleteById(String name) {
		// TODO Auto-generated method stub
//		return this.clear(getCnd4DeleteById(name));
		return this.delete(name);
	}
	
//	protected abstract Condition getCnd4DeleteById(String name);
}
