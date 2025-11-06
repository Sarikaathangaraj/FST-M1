package Project;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
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
	public void createJobListingTest() {
		WebElement jobPost = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@id,'menu-item')]//a[text()='Post a Job']")));
		//driver.findElement(By.tagName("//li[contains(@id,'menu-item')]//a[text()='Jobs']"));
		jobPost.click();
		WebElement previewButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Preview']")));
		//driver.findElement(By.tagName("//li[contains(@id,'menu-item')]//a[text()='Jobs']"));
		previewButton.click();
		driver.findElement(By.id("create_account_email")).sendKeys("sarikaasri@gmail.com");
		driver.findElement(By.id("job_title")).sendKeys("Test Engineer");
		driver.findElement(By.id("job_location")).sendKeys("bangalore");
		WebElement jobType=driver.findElement(By.id("job_type"));
		Select select=new Select(jobType);
		select.selectByVisibleText("Full Time");
		WebElement iframeElement=driver.findElement(By.id("job_description_ifr"));
		driver.switchTo().frame(iframeElement);
		//tinymce
		driver.findElement(By.id("tinymce")).sendKeys("applying for job");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("application")).sendKeys("https://alchemy.hguy.co/jobs/");
		
		driver.findElement(By.id("company_name")).sendKeys("tcre");
		driver.findElement(By.id("company_website")).sendKeys("https://alchemy.hguy.co/jobs/");
		previewButton.click();
		
		WebElement submitListingButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("job_preview_submit_button")));
		//driver.findElement(By.tagName("//li[contains(@id,'menu-item')]//a[text()='Jobs']"));
		submitListingButton.click();
		
		
	}

	@Test
	public void jobPostTest() {
		WebElement heading = driver.findElement(By.tagName("h1"));
		String headingText = heading.getText();
		System.out.println("Webpage Heading: " + headingText);
		Assert.assertEquals(headingText, "Jobs");
	}
	@Test
	public void jobListingTest() {
		WebElement jobLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@id,'menu-item')]//a[text()='Jobs']")));
		//driver.findElement(By.tagName("//li[contains(@id,'menu-item')]//a[text()='Jobs']"));
		jobLink.click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='position']/h3[text()='Automation Engineer 1']")));
	
	}
	
	@AfterClass
	public void TearDown() {
		//driver.close();
	}
}