package com.capg.mobilegames.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.capg.mobilegames.beans.MobileGames;
import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMobileGamesMapper {
	
	IMobileGamesMapper INSTANCE = Mappers.getMapper(IMobileGamesMapper.class);

	@Mapping(source = "gameName", target = "gameName")
	MobileGamesDTO mobileGamesToMobileGamesDTO(MobileGames mobileGames);
	
	@Mapping(source = "gameName", target = "gameName")
	MobileGames mobileGamesDtoToMobileGames(MobileGamesDTO mobileGamesDTO);
	
	
}
