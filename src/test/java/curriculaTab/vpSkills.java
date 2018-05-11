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

public class vpSkills {
	WebDriver dr;
	@Given("^navigate to curricula tab as vp$")
	public void navigate_to_curricula_tab_as_vp() {
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	    dr=new ChromeDriver();
	    dr.get("https://dev.assignforce.revaturelabs.com");    
	    dr.findElement(By.xpath("//input[@id='username']")).sendKeys("test.vpoftech@revature.com.int1");
	    dr.findElement(By.xpath("//input[@id='password']")).sendKeys("yuvi1712");
	    dr.findElement(By.xpath("//input[@id='Login']")).click();
	}

	@When("^curricula tab clicked$")
	public void curricula_tab_clicked() throws InterruptedException {
		TimeUnit.SECONDS.sleep(7);
		dr.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[4]/a/span/span")).click();
	}

	@Then("^skills form default appear$")
	public void skills_form_default_appear() {
		String realTimeSkills = dr.findElement(By.xpath("//*[@id=\"skillArrow\"]")).getText();
		String wantedMessage = "keyboard_arrow_up";
		if (realTimeSkills.contains(wantedMessage)) {
			assertFalse(false);
		} else {
			assertFalse(true);
		}
	}
}
