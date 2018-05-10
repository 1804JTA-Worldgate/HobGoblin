package com.revature.profiletest;

import static org.testng.Assert.assertFalse;

import java.io.File;
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
	public void navigate_to_page() {
		
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	    dr=new ChromeDriver();
	    dr.get("https://dev.assignforce.revaturelabs.com");  
	    dr.findElement(By.xpath("//input[@id='username']")).sendKeys("test.trainer@revature.com.int1");
	    dr.findElement(By.xpath("//input[@id='password']")).sendKeys("trainer123");
	    dr.findElement(By.xpath("//input[@id='Login']")).click();  
	}

	@When("^profile tab click$")
	public void profile_tab_click() throws InterruptedException {
		
		TimeUnit.SECONDS.sleep(7);
	    dr.findElement(By.xpath("/html/body/div/div[1]/ng-include/div/md-content/md-nav-bar/div/nav/ul/li[6]/a")).click();
	}
	
	@When("^check trainer name$")
	public void check_trainer_name() {
	    System.out.println(dr.findElement(By.xpath("//*[@id=\"view\"]/md-card[1]/md-toolbar/div/span")).getText());
	    String actualMessage = dr.findElement(By.xpath("//*[@id=\"view\"]/md-card[1]/md-toolbar/div/span")).getText();
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
	public void click_any_select_skill_to_add_to_your_current_skill() throws InterruptedException {
		TimeUnit.SECONDS.sleep(8);
		dr.findElement(
				By.xpath("//*[@id=\"view\"]/md-card[1]/md-content[2]/div/md-chips/md-chips-wrap/md-chip[17]/div/span"))
				.click();

		TimeUnit.SECONDS.sleep(5);
		String currentSkill = dr
				.findElement(By.xpath("//*[@id=\"view\"]/md-card[1]/md-content[2]/div/md-list/button[20]")).getText();
		System.out.println(currentSkill);
		String addedSkill = "JAVA CORE";

		if (currentSkill.contains(addedSkill)) {
			assertFalse(false);
		} else {
			assertFalse(true);
		}
	
	}

	@When("^Click any current skill to remove from the list$")
	public void click_any_current_skill_to_remove_from_the_list() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
	    String b = dr.findElement(By.xpath("//*[@id=\"view\"]/md-card[1]/md-content[2]/div/md-list/button[20]/h5")).getText();
	    //System.out.println(b);
	    dr.findElement(By.xpath("//*[@id=\"view\"]/md-card[1]/md-content[2]/div/md-list/button[20]/h5")).click();
	    
	    String added = dr.findElement(By.xpath("//*[@id=\"view\"]/md-card[1]/md-content[2]/div/md-chips/md-chips-wrap/md-chip[33]/div")).getText();
	    //System.out.println(added);
	    String current = "Java Core";
	    
	    if(added.contains(current)) {
	    	assertFalse(false);
	    }else {
	    	assertFalse(true);
	    }
	}

	@Then("^profile infornmation appear$")
	public void profile_infornmation_appear() {
	    
	    
	    
	}

}
