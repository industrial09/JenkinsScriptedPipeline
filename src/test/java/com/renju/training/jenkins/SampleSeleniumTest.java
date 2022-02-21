package com.renju.training.jenkins;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleSeleniumTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Christian Bautista\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
	}
	
	@Test
	public void validateGoogleId() throws Exception {
		System.out.println("Opening Site");
		driver.get("http://eaapp.somee.com/");
		System.out.println("Entering credentials");
		driver.findElement(By.xpath("//*[@id='loginLink']")).click();
		driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("password");
		System.out.println("Clicking Sign In link");
		driver.findElement(By.xpath("//*[@value='Log in']")).click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Hello admin')]")).isDisplayed());
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
