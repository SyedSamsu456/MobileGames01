package com.capg.mobilegames;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@Suite
@SelectPackages({"com.capg.mobilegames.controller"
	,"com.capg.mobilegames.service"})
@SpringBootTest
public class MobileGamesApplicationTests {

}
