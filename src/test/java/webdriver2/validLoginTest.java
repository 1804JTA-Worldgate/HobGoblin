package webdriver2;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class validLoginTest {

	WebDriver dr;

	@Given("^navigate to assignforce page$")
	public void navigate() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		dr = new ChromeDriver();
		dr.get(prop.getProperty("url"));
	}

	@When("^user logged in with credentials")
	public void login() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		dr.findElement(By.xpath(prop.getProperty("loginUser"))).sendKeys(prop.getProperty("trainerUser"));
		dr.findElement(By.xpath(prop.getProperty("loginPass"))).sendKeys(prop.getProperty("trainerPass"));
		dr.findElement(By.xpath(prop.getProperty("loginButton"))).click();
	}

	@Then("^home page should be displayed$")
	public void verifySuccessful() throws IOException {
		try {
			Properties prop = new Properties();
			InputStream input = null;
			input = new FileInputStream("src/test/resources/cuong.properties");
			prop.load(input);
			TimeUnit.SECONDS.sleep(7);
			String current = dr.getCurrentUrl();
			System.out.println(dr.getCurrentUrl());
			if (current.contains(prop.getProperty("homePage"))) {
				assertFalse(false);
			} else {
				assertFalse(true);
			}
			dr.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}