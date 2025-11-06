package Project;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.manage().window().maximize();
	}
	@Test
	public void jobLink() {
		
		WebElement jobLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@id,'menu-item')]//a[text()='Jobs']")));
		//driver.findElement(By.tagName("//li[contains(@id,'menu-item')]//a[text()='Jobs']"));
		jobLink.click();
		Assert.assertEquals(driver.getTitle(), "Jobs – Alchemy Jobs");
	}
	@AfterClass
	public void TearDown() {
		//driver.close();
	}
}