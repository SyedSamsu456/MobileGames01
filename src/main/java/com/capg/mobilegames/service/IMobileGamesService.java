package com.capg.mobilegames.service;

import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;

public interface IMobileGamesService {

	MobileGamesDTO addMobileGame(MobileGamesDTO mobileGameDTO);

	MobileGamesDTO getMobileGame(long id);

}
