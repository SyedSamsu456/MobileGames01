package com.capg.mobilegames;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capg.mobilegames.beans.MobileGames;
import com.capg.mobilegames.repository.IMobileGamesRepo;


@SpringBootApplication
public class MobileGamesApplication {
	
	@Autowired
	private IMobileGamesRepo mobileGamesRepo;

	public static void main(String[] args) {
		SpringApplication.run(MobileGamesApplication.class, args);
	}
	
	@PostConstruct
	protected void init() {
		MobileGames mobileGames = new MobileGames();
		MobileGames mobileGames1 = new MobileGames();
		MobileGames mobileGames2 = new MobileGames();
		mobileGames.setGameName("PUBG");
		mobileGames.setGameRating(10);
		mobileGames1.setGameName("PES");
		mobileGames1.setGameRating(7);
		mobileGames2.setGameName("FREE FIRE");
		mobileGames2.setGameRating(5);
		mobileGamesRepo.save(mobileGames);
		mobileGamesRepo.save(mobileGames1);
		mobileGamesRepo.save(mobileGames2);	
	}
	
}
