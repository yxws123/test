package com.kline.core.service.impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;

import com.kline.core.entity.Agent;
import com.kline.core.entity.User;
import com.kline.core.service.AgentService;
import com.kline.util.StringUtils;

public class AgentServiceImpl extends BaseNameEntityServiceImpl<Agent>
		implements AgentService {

	@Override
	public List<Agent> find(String agentCode, String officeCode,
			String agentType, String directBookingFlag) {
		// TODO Auto-generated method stub
		Condition cnd = null;
		cnd = Cnd.wrap(getSql(agentCode, officeCode, agentType, directBookingFlag));

		Pager pager = null;
		List<Agent> list = this.query(cnd, pager);

		return list;
	}

	@Override
	public QueryResult findPage(String agentCode, String officeCode,
			String agentType, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Condition cnd = null;
		cnd = Cnd.wrap(getSql(agentCode, officeCode, agentType, null));

		Pager pager = this.dao().createPager(pageNumber, pageSize);
		List<Agent> list = this.query(cnd, pager);
		pager.setRecordCount(this.count(cnd));
		return new QueryResult(list, pager);
	}

	private String getSql(String agentCode, String officeCode, String agentType, String directBookingFlag) {

		String sql = "where 1=1";
		if (null != agentCode && !"".equals(agentCode)) {
			sql += " and agentCode like "
					+ StringUtils.toSqlString(agentCode + "%");
		}
		if (null != officeCode && !"".equals(officeCode)) {
			sql += " and officeCode = " + StringUtils.toSqlString(officeCode);
		}
		if (null != agentType && !"".equals(agentType)) {
			sql += " and agentType = " + StringUtils.toSqlString(agentType);
		}

		if (null != directBookingFlag && !"".equals(directBookingFlag)) {
			sql += " and directBookingFlag=" + StringUtils.toSqlString(directBookingFlag);
		}
		return sql;

	}
}
