package curriculaTab;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class defaultCurricula {
	WebDriver dr;
	@Given("^navigate to curricula tab$")
	public void navigate_to_curriculate_tab() {
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	    dr=new ChromeDriver();
	    dr.get("https://dev.assignforce.revaturelabs.com");    
	    dr.findElement(By.xpath("//input[@id='username']")).sendKeys("test.trainer@revature.com.int1");
	    dr.findElement(By.xpath("//input[@id='password']")).sendKeys("trainer123");
	    dr.findElement(By.xpath("//input[@id='Login']")).click();
	}

	@When("^curricula tab is clicked$")
	public void curricula_tab_is_clicked() {
		try {
			TimeUnit.SECONDS.sleep(7);
			dr.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[4]/a/span/span")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^curricula default$")
	public void curricula_default() {
	       String realtimeCore = dr.findElement(By.xpath("//*[@id=\"coreArrow\"]")).getText();
	       String realtimeFocus = dr.findElement(By.xpath("//*[@id=\"focusArrow\"]")).getText();
	       String curriculaDefault = "keyboard_arrow_up";
	       if (realtimeCore.contains(curriculaDefault) & realtimeFocus.contains(curriculaDefault)) {
	    	  assertFalse(false);
	    	  dr.close();
	       } else {
	    	  assertFalse(true);
	    	  dr.close();
	       }
		}
	}
