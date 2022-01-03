package com.capg.mobilegames.wiremock;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class MobileGamesWireMock {

	private static final int port = 9090;
	private static final String url = "/api/mobilegames/**";
	private static final String host = "localhost";

	private static WireMockServer server = new WireMockServer(port);

	@BeforeClass
	public static void setup() {
		server.start();
		ResponseDefinitionBuilder response = new ResponseDefinitionBuilder();
		response.withStatus(200);
		WireMock.configureFor(host, port);
		WireMock.stubFor(WireMock.get(url).willReturn(response));
	}

	@Test
	public void testRetriveEndPoint() {
		RestAssured.given()
		.when()
		.get("http://localhost:9090/api/mobilegames/getGames/2")
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	@Test
	public void testRetriveEndPointWrong() {
		RestAssured.given()
		.when()
		.get("http://localhost:9090/api/mobilegames/getGaming/2")
		.then()
		.assertThat()
		.statusCode(404);	
	}
	
	@Test
	public void testAddEndPoint() {
		
		String payload = "{\r\n"
				+ "    \"gameName\":\"efootball\",\r\n"
				+ "    \"gameRating\": 6\r\n"
				+ "}";
		
		RestAssured.given()
		.header("Content-Type","application/json")
		.body(payload)
		.post("http://localhost:9090/api/mobilegames/addGames")
		.then()
		.assertThat()
		.statusCode(200);
	}

	@Test
	public void testAddEndPointWrong() {
		String payload = "{\r\n"
				+ "    \"gameName\":\"efootball\",\r\n"
				+ "    \"gameRating\": 6\r\n"
				+ "}";
		
		RestAssured.given()
		.header("Content-Type","application/json")
		.body(payload)
		.post("http://localhost:9090/api/mobilegames/addGaming")
		.then()
		.assertThat()
		.statusCode(404);	
	}
	
	@AfterClass
	public void tearDown() {
		if(null!=server && server.isRunning()) {
			server.shutdownServer();
		}
	}
	
	
}
