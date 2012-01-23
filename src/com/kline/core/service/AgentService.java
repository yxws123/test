package com.kline.core.service;

import java.util.List;

import org.nutz.dao.QueryResult;

import com.kline.core.entity.Agent;

public interface AgentService extends BaseNameEntityService {

	// public void insertAgent(Agent agent);
	//
	// public void updateAgent(Agent agent);
	//
	// public void deleteAgentById(String agentCode);
	//
	// public Agent getAgentById(String agentCode);

	public List<Agent> find(String agentCode, String officeCode,
			String agentType, String directBookingFlag);

	public QueryResult findPage(String agentCode, String officeCode,
			String agentType, int pageNumber, int pageSize);

}
