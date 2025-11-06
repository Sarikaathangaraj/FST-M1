package Project;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.manage().window().maximize();
	}

	@Test
	public void getTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application");

	}

	@Test
	public void webpageHeadingTest() {
		WebElement heading = driver.findElement(By.tagName("h1"));
		String headingText = heading.getText();
		System.out.println("Webpage Heading: " + headingText);
		Assert.assertEquals("Welcome to Alchemy Jobs", headingText);
	}

	@AfterClass
	public void TearDown() {
		driver.close();
	}
}