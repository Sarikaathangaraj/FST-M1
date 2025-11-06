package Project;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		driver.manage().window().maximize();
	}
	@Test
	public void websiteLoginTest() {
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		
	}
	@Test
	public void getTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Log In ‹ Alchemy Jobs — WordPress");
	}
	
	@AfterClass
	public void TearDown() {
		//driver.close();
	}
}