package com.capg.mobilegames.healthcheck;

import static com.capg.mobilegames.utils.MobileGamesConstants.BACKEND_CALL;
import static com.capg.mobilegames.utils.MobileGamesConstants.LOGGER;
import static com.capg.mobilegames.utils.MobileGamesConstants.QUERY;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHealthCheck implements HealthIndicator {

	@Autowired
	private DataSource ds;

	@Override
	public Health health() {

		LOGGER.info("Mobile Games Database Health Check : health method is initialized");

		try (Connection conn = ds.getConnection()) {
			Statement stmt = conn.createStatement();
			stmt.execute(QUERY);
		} catch (SQLException ex) {
			
			LOGGER.info("Mobile Games Database Health Check : health method catch is executed");
			
			return Health.down().withDetail(BACKEND_CALL, "Service is not working").withException(ex)
					.build();
		}
		
		LOGGER.info("Mobile Games Database Health Check : health method try is executed");
		
		return Health.up().withDetail(BACKEND_CALL,"Service is working").build();
	}

}
