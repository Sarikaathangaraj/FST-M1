package Project;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
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
	public void searchJobTest() {
		WebElement jobLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@id,'menu-item')]//a[text()='Jobs']")));
		//driver.findElement(By.tagName("//li[contains(@id,'menu-item')]//a[text()='Jobs']"));
		jobLink.click();
		WebElement jobSearcBox=driver.findElement(By.id("search_keywords"));
		wait.until(ExpectedConditions.elementToBeClickable(jobSearcBox));
		jobSearcBox.sendKeys("Banking");
		WebElement searchJobs=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
		searchJobs.click();
		;
		WebElement joblink=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='job_listings']//li)[1]")));
		joblink.click();
		WebElement applyJobButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Apply for job']")));
		applyJobButton.click();
		//driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
		String emailText=driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();
		System.out.println(emailText);
	}
	
	
	
	
	@AfterClass
	public void TearDown() {
		//driver.close();
	}
}