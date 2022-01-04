package com.capg.mobilegames.service;

import static com.capg.mobilegames.utils.MobileGamesConstants.LOGGER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capg.mobilegames.beans.MobileGames;
import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;
import com.capg.mobilegames.mapstruct.mapper.IMobileGamesMapper;
import com.capg.mobilegames.repository.IMobileGamesRepo;

@ExtendWith(MockitoExtension.class)
class MobileGamesServiceTest {

	@Mock
    private IMobileGamesRepo repository;
	
	@InjectMocks
    private MobileGamesService service;
	
	@Mock
	private IMobileGamesMapper mapper;
	
	//Given
	private MobileGames mg = mock(MobileGames.class);
	
	private MobileGamesDTO mgDTO = mock(MobileGamesDTO.class);
	
	private NullPointerException nullPointException = mock(NullPointerException.class);
	
	@Test
	void testAddMobileGame() {
		
		LOGGER.info("Mobile Games Service Test: testaddMobileGame method is initialized");
	
		//When //then
		when(repository.save(mg)).thenReturn(mg);
		when(mapper.mobileGamesToMobileGamesDTO(mg)).thenReturn(mgDTO);
		
		//Verify
		MobileGamesDTO mgNewDTO = service.addMobileGame(mgDTO);
		
		assertEquals(mgDTO, mgNewDTO);
		
		verify(repository).save(any(MobileGames.class));
		verify(mapper).mobileGamesToMobileGamesDTO(any(MobileGames.class));
		
		LOGGER.info("Mobile Games Service Test: testaddMobileGame method is executed");
		
	}

	@Test
	void testGetMobileGame() {
		
		LOGGER.info("Mobile Games Service Test: testgetMobileGame method is initialized");
		
		//Given
		Optional<MobileGames> mgo = Optional.of(mg);

		//WHen //then
		when(repository.findById(any(Long.class))).thenReturn(mgo);
		when(mapper.mobileGamesToMobileGamesDTO(mgo.get())).thenReturn(mgDTO);
		
		//Verify
		MobileGamesDTO mgNewDTO = service.getMobileGame(any(Long.class));
		
		assertEquals(mgDTO, mgNewDTO);
		
		verify(repository,times(1)).findById(any(Long.class));
		verify(mapper).mobileGamesToMobileGamesDTO(any(MobileGames.class));
		
		LOGGER.info("Mobile Games Service Test: testgetMobileGame method is executed");
		
	}
	
	@Test
	void testGetMobileGameThrowException(){
		
		LOGGER.info("Mobile Games Service Test: testgetMobileGamethrowException method is initialized");

		when(repository.findById(any(Long.class)))
		.thenThrow(nullPointException);
		
		assertThrows(nullPointException.getClass(), () -> service.getMobileGame(any(Long.class)));
		
		verify(repository,times(1)).findById(any(Long.class));	
		
		LOGGER.info("Mobile Games Service Test: testgetMobileGamethrowException method is executed");

	}

}









