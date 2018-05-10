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

public class forgotpasswordTest {
	WebDriver dr;
	@Given("^navigate to login$")
	public void navigate_to_login() {
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	    dr=new ChromeDriver();
	    dr.get("https://dev.assignforce.revaturelabs.com");
	}

	@When("^user click forgot password button$")
	public void user_click_forgot_password_button() {
	       dr.findElement(By.xpath("//*[@id=\"forgot_password_link\"]")).click();
	}

	@Then("^redirects to forgot password page$")
	public void redirects_to_forgot_password_page() {
		try {
			TimeUnit.SECONDS.sleep(7);
			String actual = dr.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
		    if (actual.contains("Having trouble logging in?")) {
		    	assertFalse(false);
		    	dr.close();
		    }
		    else
		    	assertFalse(true);
		    	dr.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
