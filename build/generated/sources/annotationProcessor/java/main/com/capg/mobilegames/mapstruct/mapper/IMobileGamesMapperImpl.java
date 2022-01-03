package com.capg.mobilegames.mapstruct.mapper;

import com.capg.mobilegames.beans.MobileGames;
import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-03T16:14:10+0530",
    comments = "version: 1.4.0.Beta2, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.jar, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class IMobileGamesMapperImpl implements IMobileGamesMapper {

    @Override
    public MobileGamesDTO mobileGamesToMobileGamesDTO(MobileGames mobileGames) {
        if ( mobileGames == null ) {
            return null;
        }

        MobileGamesDTO mobileGamesDTO = new MobileGamesDTO();

        mobileGamesDTO.setGameName( mobileGames.getGameName() );
        mobileGamesDTO.setId( mobileGames.getId() );
        mobileGamesDTO.setGameRating( mobileGames.getGameRating() );

        return mobileGamesDTO;
    }

    @Override
    public MobileGames mobileGamesDtoToMobileGames(MobileGamesDTO mobileGamesDTO) {
        if ( mobileGamesDTO == null ) {
            return null;
        }

        MobileGames mobileGames = new MobileGames();

        mobileGames.setGameName( mobileGamesDTO.getGameName() );
        mobileGames.setId( mobileGamesDTO.getId() );
        mobileGames.setGameRating( mobileGamesDTO.getGameRating() );

        return mobileGames;
    }
}
