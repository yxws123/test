package com.kline.core.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.kline.BaseTestCase;
import com.kline.Constants;
import com.kline.core.entity.Agent;
import com.kline.core.service.AgentService;

public class AgentServiceTest extends BaseTestCase {

	private AgentService agentService;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		agentService = acMgr.getBean(null, "agentService");
	}

	@Test
	public void testInsertAgent() {
		fail("Not yet implemented");
		
//		Agent agent = new Agent();
//		agent.setAgentId("agent2");
//		agent.setAgentCode(null);
//		agent.setAgentType(Constants.USERTYPE_INTERNAL);
//		agent.setEnabled(Constants.YES);
//		agent.setRole(Constants.USER_ROLE_ADMIN);
		
//		agent.setValid();
//		agent.setCreator("admin");
//		agent.setModifier("admin");
//		agent.setDateCreated(new Date());
//		agent.setLastModified(new Date());
//		agent.setNewInfo("admin");
		
//		try {
//			agentService.insertAgent(agent);
//		} catch (Exception e) {
//			fail(e.toString());
//		}				
	}

	@Test
	public void testGetAgentById() {
//		fail("Not yet implemented");
		String agentCode = "ENCINAL";
		Agent agent = null;
		try {
			agent = agentService.getById(agentCode);
		} catch (Exception e) {
			fail(e.toString());
		}
		assertNotNull(agent);
		
		String jAgent1 = Json.toJson(agent);
		String jAgent2 = Json.toJson(agent, JsonFormat.full());
		
		System.out.println(jAgent1);
		System.out.println(jAgent2);
	}

	@Test
	public void testGetAllAgents() {
//		fail("Not yet implemented");
		List<Agent> list = agentService.find(null, null, null, null);
		
		assertNotNull(list);
		
		String jAgentList = Json.toJson(list, JsonFormat.full());
		
		System.out.println(jAgentList);
	}

//	@Test
//	public void testUpdateAgentAgentString() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testDeleteAgentById() {
//		fail("Not yet implemented");

		String agentCode = "use'r1";
//		Agent agent = null;
		try {
			agentService.deleteById(agentCode);
		} catch (Exception e) {
			fail(e.toString());
		}
//		assertNotNull(agent);
	}

	@Test
	public void testUpdateAgentAgent() {
//		fail("Not yet implemented");
		
		String agentCode = "agent1";
		Agent agent = null;
		try {
			agent = agentService.getById(agentCode);
			agent.setUpdateInfo("admin");
			
			agentService.update(agent);
		} catch (Exception e) {
			fail(e.toString());
		}
		assertNotNull(agent);

	}

}
