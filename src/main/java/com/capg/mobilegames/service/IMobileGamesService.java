package com.capg.mobilegames.service;

import com.capg.mobilegames.beans.MobileGames;
import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;

public interface IMobileGamesService {

	MobileGamesDTO addMobileGame(MobileGames mobileGame);

	MobileGamesDTO getMobileGame(long id);

}
