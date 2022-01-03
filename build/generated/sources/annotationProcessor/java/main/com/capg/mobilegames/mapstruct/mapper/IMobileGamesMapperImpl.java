package com.capg.mobilegames.mapstruct.mapper;

import com.capg.mobilegames.beans.MobileGames;
import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-03T19:47:24+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.2.jar, environment: Java 15 (AdoptOpenJDK)"
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
