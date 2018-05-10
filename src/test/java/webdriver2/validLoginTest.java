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

public class validLoginTest {

WebDriver dr;
@Given("^navigate to assignforce page$")
public void navigate(){
	File chrome = new File("src/main/resources/chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
    dr=new ChromeDriver();
    dr.get("https://dev.assignforce.revaturelabs.com");         
       }
@When("^user logged in with credentials")
public void login() {
       dr.findElement(By.xpath("//input[@id='username']")).sendKeys("test.trainer@revature.com.int1");
       dr.findElement(By.xpath("//input[@id='password']")).sendKeys("trainer123");
       dr.findElement(By.xpath("//input[@id='Login']")).click();
       }
@Then("^home page should be displayed$")
public void verifySuccessful(){
	try {
		TimeUnit.SECONDS.sleep(7);
		String current = dr.getCurrentUrl();
		System.out.println(dr.getCurrentUrl());
		String home = "https://dev.assignforce.revaturelabs.com/home";
		if (current.contains(home)) {
			assertFalse(false);
			dr.close();
		}
		else
		{
			assertFalse(true);
			dr.close();
		}
			} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
}