package com.revature.service;

import cucumber.api.cli.Main;

public class callCucumber {

	public static void main(String[] args) throws Throwable {
		Main.main(new String[]{"-g", "trainerTab", "C:/revature/webdriver2/src/test/resources/trainerTest.feature"});
		Main.main(new String[]{"-g", "curriculaTab", "C:/revature/webdriver2/src/test/resources/curriculaTest.feature"});
		Main.main(new String[]{"-g", "webdriver2", "C:/revature/webdriver2/src/test/resources/loginTest.feature"});
	}
}
