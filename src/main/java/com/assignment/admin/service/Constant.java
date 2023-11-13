package com.assignment.admin.service;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Constant {
	public static final String APP_CONTEXT_PATH = "/railadmin/v1";
	
	public static final int DEFAULT_USER_ROLE = 105;
	
	public static final Integer SLEEPER_SEATS_PER_BOGIE = 30;
	public static final Integer AC3_SEATS_PER_BOGIE = 20;
	public static final Integer AC2_SEATS_PER_BOGIE = 10;
	
	public static final Map<String, Integer> bogieSeatsMap = new HashMap<>(3);
	
	{
		log.info("Updating default bogie sized");
		bogieSeatsMap.put("SLEEPER", SLEEPER_SEATS_PER_BOGIE);
		bogieSeatsMap.put("AC2", AC2_SEATS_PER_BOGIE);
		bogieSeatsMap.put("AC3", AC3_SEATS_PER_BOGIE);
	}
}
