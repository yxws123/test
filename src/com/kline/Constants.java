package com.kline;

public class Constants {

	public final static String YES = "Y";
	public final static String NO = "N";

	// OfficeCode
	public final static String OFFICE_SHANGHAI = "CNSHA";
	public final static String OFFICE_NINGBO = "CNNGB";
	public final static String OFFICE_NANJING = "CNNKG";
	public final static String OFFICE_QINGDAO = "CNTAO";
	public final static String OFFICE_TIANJIN = "CNTSN";
	public final static String OFFICE_DALIAN = "CNDLC";
	public final static String OFFICE_SUZHOU = "CNSZH";

	public final static String[] officeArray = { OFFICE_SHANGHAI,
			OFFICE_NINGBO, OFFICE_NANJING, OFFICE_QINGDAO, OFFICE_TIANJIN,
			OFFICE_DALIAN, OFFICE_SUZHOU };

	// AgentType
	public final static String AGENT_TYPE_AGENT = "A";
	public final static String AGENT_TYPE_KLINE_FORWARDER = "F";
	public final static String AGENT_TYPE_DIRECT_BOOKING = "D";

	public final static String[] agentTypeArray = { AGENT_TYPE_AGENT,
			AGENT_TYPE_DIRECT_BOOKING };
}
