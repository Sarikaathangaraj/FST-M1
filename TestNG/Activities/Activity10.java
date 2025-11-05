package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; // You can switch to FirefoxDriver if needed
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Activity10 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        // Initialize ChromeDriver (make sure chromedriver is in PATH or set System property)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // DataProvider to supply test data
    @DataProvider(name = "Events")
    public Object[][] eventData() {
        return new Object[][]{
                {List.of("John Doe", "john@example.com", "2025-11-10", "Automation event")},
                {List.of("Jane Smith", "jane@example.com", "2025-12-05", "Selenium testing")}
        };
    }

    @Test(dataProvider = "Events")
    public void registerTest(List<String> rows) throws InterruptedException {
        driver.get("https://training-support.net/webelements/simple-form");

        // Wait for the form to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("full-name")));

        // Fill in the form
        driver.findElement(By.id("full-name")).sendKeys(rows.get(0));
        driver.findElement(By.id("email")).sendKeys(rows.get(1));
        driver.findElement(By.name("event-date")).sendKeys(rows.get(2));
        driver.findElement(By.id("additional-details")).sendKeys(rows.get(3));

        // Submit the form
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Wait for confirmation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));

        // Verify confirmation message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        assertEquals(message, "Your event has been scheduled!");

        // Refresh page to reset form
        driver.navigate().refresh();
    }
}
