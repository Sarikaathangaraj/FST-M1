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

public class Activity9 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void websiteLoginTest() {
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		
	}
	@Test(priority=2)
	public void getTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Dashboard ‹ Alchemy Jobs — WordPress");
	}
	@Test(priority=3)
	public void createJobListing() {
		
		WebElement jobListing = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Job Listings']")));
		jobListing.click();
		WebElement link = driver.findElement(By.linkText("Add New"));
		link.click();
		WebElement modalCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close dialog']")));
		modalCloseButton.click();
		driver.findElement(By.xpath("//textarea[contains(@id,'post-title')]")).sendKeys("automationtest");
		//button[contains(@class,'components-button') and text()='Publish…']
		WebElement publishButton1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'components-button') and text()='Publish…']")));
		publishButton1.click();
		WebElement publishButton2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Publish']")));
		publishButton2.click();
				
		
		WebElement PublishedText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'header-published')]")));
		
		
		String ActualText=PublishedText.getText();

			System.out.println("ActualText" + ActualText);
			Assert.assertEquals("Published",ActualText);
		//driver.findElement(By.xpath("//a[contains(@class,'components-button') and text()='View Job']")).click();
	}
	
	@AfterClass
	public void TearDown() {
		//driver.close();
	}
}