package com.revature.profiletest;

import static org.testng.Assert.assertFalse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class profileTabAppear {
	WebDriver dr;
	@Given("^navigate to page$")
	public void navigate_to_page() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/bala.properties");
		prop.load(input);
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	    dr=new ChromeDriver();
	    dr.get(prop.getProperty("url"));   
	    dr.findElement(By.xpath(prop.getProperty("userInput"))).sendKeys(prop.getProperty("trainerUser"));
	    dr.findElement(By.xpath(prop.getProperty("passwordInput"))).sendKeys(prop.getProperty("trainerPass"));
	    dr.findElement(By.xpath(prop.getProperty("loginButton"))).click();  
	}

	@When("^profile tab click$")
	public void profile_tab_click() throws InterruptedException, IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/bala.properties");
		prop.load(input);
		TimeUnit.SECONDS.sleep(7);
	    dr.findElement(By.xpath(prop.getProperty("profiletab"))).click();
	}
	
	@When("^check trainer name$")
	public void check_trainer_name() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/bala.properties");
		prop.load(input);
	    //System.out.println(dr.findElement(By.xpath(prop.getProperty("trainername"))).getText());
	    String actualMessage = dr.findElement(By.xpath(prop.getProperty("trainername"))).getText();
	    String wantedMessage = "Profile";
	    if (actualMessage.contains(wantedMessage)) {
	    	//System.out.println("True");
	    	assertFalse(false);
	    } else {
	    	//System.out.println("False");
	    	assertFalse(true);
	    }
	}
	
	@When("^click any select skill to add to your current skill$")
	public void click_any_select_skill_to_add_to_your_current_skill() throws InterruptedException, IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/bala.properties");
		prop.load(input);
		TimeUnit.SECONDS.sleep(8);
		dr.findElement(
				By.xpath(prop.getProperty("selectSkill")))
				.click();

		TimeUnit.SECONDS.sleep(5);
		String currentSkill = dr
				.findElement(By.xpath(prop.getProperty("checkskill"))).getText();
		System.out.println(currentSkill);
		String addedSkill = "B";

		if (currentSkill.contains(addedSkill)) {
			assertFalse(false);
		} else {
			assertFalse(true);
		}
	
	}

	@When("^Click any current skill to remove from the list$")
	public void click_any_current_skill_to_remove_from_the_list() throws InterruptedException, IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/bala.properties");
		prop.load(input);
		TimeUnit.SECONDS.sleep(5);
	    dr.findElement(By.xpath(prop.getProperty("checkskill"))).click();
	    String added = dr.findElement(By.xpath(prop.getProperty("unselect"))).getText();
	    String current = "b";
	    
	    if(added.contains(current)) {
	    	assertFalse(false);
	    }else {
	    	assertFalse(true);
	    }
	}
	
	@When("^upload and remove certificate$")
	public void upload_and_remove_certificate() throws InterruptedException, IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/bala.properties");
		prop.load(input);
		dr.findElement(By.xpath(prop.getProperty("uploadbutton"))).click();
	    TimeUnit.SECONDS.sleep(5);
	    dr.findElement(By.xpath(prop.getProperty("fileInput"))).sendKeys(prop.getProperty("fileName"));
	    dr.findElement(By.xpath(prop.getProperty("fileUpdate"))).click();
	    TimeUnit.SECONDS.sleep(3);
	    dr.findElement(By.xpath(prop.getProperty("removeCertificate"))).click();
	}
	
	@Then("^profile infornmation appear$")
	public void profile_infornmation_appear() {
	    
	    
	}

}
