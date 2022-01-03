package com.capg.mobilegames.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.capg.mobilegames.beans.MobileGames;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
public class StepDefinitions {
	
	MobileGames mobileGame = new MobileGames();
	
	List<MobileGames> list = new ArrayList<MobileGames>();
	
	@Given("mobile game data")
	public void mobile_game_data() {
		mobileGame = new MobileGames(1,"Pes", 8);
	}

	@When("I add the mobile game data")
	public void i_add_the_mobile_game_data() {
		list.add(mobileGame);
	}

	@Then("mobile game data added succesfully")
	public void mobile_game_data_added_succesfully() {
		assertEquals(mobileGame.getGameName(),list.get(0).getGameName());
	}
	
}
