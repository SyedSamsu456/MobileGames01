package com.capg.mobilegames.beans;

import static com.capg.mobilegames.utils.MobileGamesConstants.BLANKMESSSAGE;
import static com.capg.mobilegames.utils.MobileGamesConstants.MAXMESSSAGE;
import static com.capg.mobilegames.utils.MobileGamesConstants.MINMESSSAGE;
import static com.capg.mobilegames.utils.MobileGamesConstants.NULLMESSSAGE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class MobileGames {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull(message = NULLMESSSAGE)
	@NotBlank(message = BLANKMESSSAGE)
	private String gameName;
	
	@Min(value = 1,message = MINMESSSAGE)
	@Max(value = 10,message = MAXMESSSAGE)
	private int gameRating;

	public MobileGames(long id,
			@NotNull(message = NULLMESSSAGE) @NotBlank(message = BLANKMESSSAGE) String gameName,
			@Min(value = 1, message = MINMESSSAGE) @Max(value = 10, message = MAXMESSSAGE) int gameRating) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.gameRating = gameRating;
	}

	public MobileGames() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getGameRating() {
		return gameRating;
	}

	public void setGameRating(int gameRating) {
		this.gameRating = gameRating;
	} 
	
	

}
