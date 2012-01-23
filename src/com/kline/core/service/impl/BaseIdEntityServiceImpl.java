package com.kline.core.service.impl;

//import org.nutz.dao.Condition;
import org.nutz.service.IdEntityService;

import com.kline.core.service.BaseIdEntityService;

public abstract class BaseIdEntityServiceImpl<T> extends IdEntityService<T> implements
		BaseIdEntityService {

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
	public <T> T getById(long id) {
		// TODO Auto-generated method stub
		return (T) this.fetch(id);
	}

//	@Override
//	public int delete(Object obj) {
//		// TODO Auto-generated method stub
//		return this.dao().delete(obj);
//	}
	
	@Override
	public int deleteById(long id) {
		// TODO Auto-generated method stub
		//return this.clear(getCnd4DeleteById(id));
		return this.delete(id);
	}
	
//	protected abstract Condition getCnd4DeleteById(long id);
}
