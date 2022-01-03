package com.capg.mobilegames.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MobileGamesConstants {
	
	public static final String NULLMESSSAGE = " Game name should not be null";
	public static final String BLANKMESSSAGE = " Game name should not be blank";
	public static final String MINMESSSAGE = " Game rating should be 1 to 10";
	public static final String MAXMESSSAGE = " Game rating should be 1 to 10";
	public static final String BACKEND_CALL = "H2 Datadase";
	public static final String DATABASE ="database";
	public static final String QUERY = "SELECT * FROM MOBILE_GAMES";
	
	
	public static final String API = "${API}";
	public static final String GET = "${GET}";
	public static final String POST = "${POST}";
	
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MobileGamesConstants.class);
	
}
