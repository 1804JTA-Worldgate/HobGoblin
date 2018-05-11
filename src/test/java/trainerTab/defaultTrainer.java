package trainerTab;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class defaultTrainer {
	WebDriver dr;
	@Given("^navigate to trainer tab$")
	public void navigate_to_trainer_tab() {
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	    dr=new ChromeDriver();
	    dr.get("https://dev.assignforce.revaturelabs.com");    
	    dr.findElement(By.xpath("//input[@id='username']")).sendKeys("test.trainer@revature.com.int1");
	    dr.findElement(By.xpath("//input[@id='password']")).sendKeys("trainer123");
	    dr.findElement(By.xpath("//input[@id='Login']")).click();
	}

	@When("^trainer tab is clicked$")
	public void trainer_tab_is_clicked() throws InterruptedException {
		TimeUnit.SECONDS.sleep(7);
		dr.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[5]/a")).click();
		
	}

	@Then("^trainer tables should show$")
	public void trainer_tables_should_show() {
		String realTable1 = dr.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-toolbar[1]/div/span[1]")).getText();
		String realTable2 = dr.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-toolbar[2]/div/span[1]")).getText();
		String wantTable1 = "Trainers";
		String wantTable2 = "Inactive Trainers";
		if (realTable1.contains(wantTable1) & realTable2.contains(wantTable2))
		{
			assertFalse(false);
			dr.close();
		}
		else {
			assertFalse(true);
			dr.close();
		}
		
	}
}
