package com.capg.mobilegames.healthcheck;

import static com.capg.mobilegames.utils.MobileGamesConstants.DATABASE;
import static com.capg.mobilegames.utils.MobileGamesConstants.LOGGER;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeHealthContributor;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.NamedContributor;
import org.springframework.stereotype.Component;

@Component("mobilegamesAPI")
public class MobileGamesCheck implements CompositeHealthContributor {
	
	private Map<String, HealthContributor> contributors = new LinkedHashMap<>();

	@Autowired
	public MobileGamesCheck(DatabaseHealthCheck databaseHealthCheck) {
		
		contributors.put(DATABASE, databaseHealthCheck);
	}

	@Override
	public HealthContributor getContributor(String name) {
		
		LOGGER.info("Mobile Games Check: getContributor method is initialized and Executed");
		
		return contributors.get(name);
	}

	@Override
	public Iterator<NamedContributor<HealthContributor>> iterator() {
		
		LOGGER.info("Mobile Games Check: iterator method is initialized and Executed");
		
		return contributors.entrySet().stream()
			       .map((entry) -> 
			          NamedContributor.of(entry.getKey(), 
			              entry.getValue())).iterator();
	}

}
