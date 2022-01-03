package com.capg.mobilegames.service;

import static com.capg.mobilegames.utils.MobileGamesConstants.LOGGER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mobilegames.beans.MobileGames;
import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;
import com.capg.mobilegames.mapstruct.mapper.IMobileGamesMapper;
import com.capg.mobilegames.repository.IMobileGamesRepo;

@Service("service")
public class MobileGamesService implements IMobileGamesService {

	
	@Autowired
	private IMobileGamesRepo mobileGamesRepo;
	
	@Autowired
	private IMobileGamesMapper mobileGamesMapper;

	@Override
	public MobileGamesDTO addMobileGame(MobileGames mobileGame) {
		
		LOGGER.info("Mobile Games Service: addMobileGame method is initialized");
		
		MobileGames addedmobileGame = mobileGamesRepo.save(mobileGame);
		
		LOGGER.info("Mobile Games Service: addMobileGame method is executed");

		//return mobileGamesMapper.mobileGamesToMobileGamesDTO(addedmobileGame);
		return mobileGamesMapper.INSTANCE.mobileGamesToMobileGamesDTO(addedmobileGame);
	}

	@Override
	public MobileGamesDTO getMobileGame(long id) {
		
		LOGGER.info("MobileGamesService: getMobileGame method is initialized");
		
		MobileGames getMobileGame = mobileGamesRepo.findById(id).orElseThrow(() -> {
			throw new NullPointerException("No Game Availale for given Id");
		});
		
		LOGGER.info("Mobile Games Service: addMobileGame method is executed");
		
		//return mobileGamesMapper.mobileGamesToMobileGamesDTO(getMobileGame);
		return mobileGamesMapper.INSTANCE.mobileGamesToMobileGamesDTO(getMobileGame);
	}
}
