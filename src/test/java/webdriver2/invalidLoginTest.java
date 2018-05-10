package webdriver2;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class invalidLoginTest {
	WebDriver dr;
	@Given("^navigate to login page$")
	public void navigate_to_login_page() {
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	    dr=new ChromeDriver();
	    dr.get("https://dev.assignforce.revaturelabs.com");   
	}

	@When("^user logged in with incorrect credentials$")
	public void user_logged_in_with_incorrect_credentials() {
	       dr.findElement(By.xpath("//input[@id='username']")).sendKeys("wrong");
	       dr.findElement(By.xpath("//input[@id='password']")).sendKeys("wrong");
	       dr.findElement(By.xpath("//input[@id='Login']")).click();
	       }

	@Then("^error message appears$")
	public void error_message_appears() {
		try {
			TimeUnit.SECONDS.sleep(7);
			String actualMessage = dr.findElement(By.xpath("//*[@id=\"error\"]")).getText();
			String errorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
			if (actualMessage.contains(errorMessage)) {
				assertFalse(false);
				dr.close();
			}
			else {
				assertFalse(true);
				dr.close();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
