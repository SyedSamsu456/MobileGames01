package com.capg.mobilegames.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.capg.mobilegames.beans.MobileGames;
import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;

@Mapper(componentModel = "spring")
public interface IMobileGamesMapper {
	
	IMobileGamesMapper INSTANCE = Mappers.getMapper(IMobileGamesMapper.class);

	@Mapping(source = "gameName", target = "gameName")
	MobileGamesDTO mobileGamesToMobileGamesDTO(MobileGames mobileGames);
	
	@Mapping(source = "gameName", target = "gameName")
	MobileGames mobileGamesDtoToMobileGames(MobileGamesDTO mobileGamesDTO);
	
	
}
