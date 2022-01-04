//package com.capg.mobilegames.mapstruct.mapper;
//
//
//import org.springframework.stereotype.Component;
//
//import com.capg.mobilegames.beans.MobileGames;
//import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;
//
//@Component
//public class MobileGamesMapper implements IMobileGamesMapper{
//
//	@Override
//	public MobileGamesDTO mobileGamesToMobileGamesDTO(MobileGames mobileGames) {
//
//		LOGGER.info("Mobile Games Mapper : MobileGames to MobileGamesDTO is initialized");
//
//		if(mobileGames == null) {
//			return null;
//		}
//		MobileGamesDTO mobileGamesDto = new MobileGamesDTO();
//		mobileGamesDto.setId(mobileGames.getId());
//		mobileGamesDto.setGameName(mobileGames.getGameName());
//		mobileGamesDto.setGameRating(mobileGames.getGameRating());
//
//		LOGGER.info("Mobile Games Mapper : MobileGames to MobileGamesDTO is Executed");
//
//		return mobileGamesDto;
//
//	}
//
//	@Override
//	public MobileGames mobileGamesDtoToMobileGames(MobileGamesDTO mobileGamesDTO) {
//
//		LOGGER.info("Mobile Games Mapper: MobileGamesDTO to MobileGames is initialized");
//
//		if(mobileGamesDTO == null) {
//			return null;
//		}
//		MobileGames mobileGames = new MobileGames();
//		mobileGames.setId(mobileGamesDTO.getId());
//		mobileGames.setGameName(mobileGamesDTO.getGameName());
//		mobileGames.setGameRating(mobileGamesDTO.getGameRating());
//
//		LOGGER.info("Mobile Games Mapper : MobileGamesDTO to MobileGames is Executed");
//
//		return mobileGames;
//
//	}
//
//}
