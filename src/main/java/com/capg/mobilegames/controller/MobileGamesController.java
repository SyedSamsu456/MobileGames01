package com.capg.mobilegames.controller;

import static com.capg.mobilegames.utils.MobileGamesConstants.API;
import static com.capg.mobilegames.utils.MobileGamesConstants.GET;
import static com.capg.mobilegames.utils.MobileGamesConstants.LOGGER;
import static com.capg.mobilegames.utils.MobileGamesConstants.POST;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.capg.mobilegames.beans.MobileGames;
import com.capg.mobilegames.mapstruct.dto.MobileGamesDTO;
import com.capg.mobilegames.service.IMobileGamesService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestController
@RefreshScope
@RequestMapping(API)
public class MobileGamesController {

	@Autowired
	private IMobileGamesService mobileGamesService;


	@PostMapping(POST)
	public ResponseEntity<MobileGamesDTO> addMobileGame(@RequestBody MobileGames mobileGame) {

		LOGGER.info("Mobile Games Controller: addMobileGame method is initialized");

		MobileGamesDTO mobileGamesDTO = mobileGamesService.addMobileGame(mobileGame);
		
		LOGGER.info("Mobile Games Controller: addMobileGame method is executed");

		return new ResponseEntity<>(mobileGamesDTO, HttpStatus.OK);

	}

	@GetMapping(GET)
	public ResponseEntity<MobileGamesDTO> getMobileGame(@PathVariable long id) {

		LOGGER.info("Mobile Games Controller: getMobileGame method is initialized");

		MobileGamesDTO mobileGamesDTO = mobileGamesService.getMobileGame(id);

		LOGGER.info("Mobile Games Controller: getMobileGame method is executed");
		
		return new ResponseEntity<>(mobileGamesDTO, HttpStatus.OK);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Object> exceptionConstraintViolationException(ConstraintViolationException exception) {

		StringBuilder msg = new StringBuilder();

		exception.getConstraintViolations().forEach(i -> msg.append(i.getConstraintDescriptor().getMessageTemplate()));

		LOGGER.info("Mobile Games Controller Exception : exceptionConstraintViolation Exception is handled");
		
		return new ResponseEntity<>(msg.toString(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> exceptionInvalidInputException(NullPointerException exception) {
		
		LOGGER.info("Mobile Games Controller Exception : Invalid Input Exception is handled");
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
     public ResponseEntity<Object> exceptionTypeMisMatchException(MethodArgumentTypeMismatchException exception) {
		
		LOGGER.info("Mobile Games Controller Exception : Method Argument Type Mismatch Exception is handled");
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	@ExceptionHandler(value = InvalidFormatException.class)
    public ResponseEntity<Object> exceptioninvalidFormatException( InvalidFormatException exception) {
		
		LOGGER.info("Mobile Games Controller Exception : Method Argument Type Mismatch Exception is handled");
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		
	}

}
