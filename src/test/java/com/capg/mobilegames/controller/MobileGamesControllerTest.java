package com.capg.mobilegames.controller;

import static com.capg.mobilegames.utils.MobileGamesConstants.LOGGER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;
import com.capg.mobilegames.service.MobileGamesService;

@ExtendWith(MockitoExtension.class)
class MobileGamesControllerTest {
	
	@Mock
	private MobileGamesService service;
	
	@InjectMocks
	private MobileGamesController controller;
		
	private MobileGamesDTO mgDTO = mock(MobileGamesDTO.class);
		
	@Test
	void testAddMobileGame() {
		LOGGER.info("Mobile Games Controller Test: testaddMobileGame method is initialized");
		
		//When //then
		when(service.addMobileGame(mgDTO)).thenReturn(mgDTO);
		
		//Verify
		MobileGamesDTO mgNewDTO = service.addMobileGame(mgDTO);
		
		assertEquals(mgDTO, mgNewDTO);
		
		verify(service).addMobileGame(any(MobileGamesDTO.class));
		
		
		LOGGER.info("Mobile Games Controller Test: testaddMobileGame method is executed");
	}

	@Test
	void testGetMobileGame() {
		LOGGER.info("Mobile Games Controller Test: testgetMobileGame method is initialized");

		//WHen //then
		when(service.getMobileGame(any(Long.class))).thenReturn(mgDTO);
		
		//Verify
		MobileGamesDTO mgNewDTO = service.getMobileGame(any(Long.class));
		
		assertEquals(mgDTO, mgNewDTO);
		
		verify(service,times(1)).getMobileGame(any(Long.class));
		
		LOGGER.info("Mobile Games Controller Test: testgetMobileGame method is executed");
	}

}
