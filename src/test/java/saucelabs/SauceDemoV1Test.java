package saucelabs;

import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SauceDemoV1Test {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/windows/x64/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:/WebDriver/windows/x64/geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:/WebDriver/windows/x64/msedgedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void cleanup() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        if (driver != null)
            driver.quit();
    }

    @Test
    public void testApp() {
        driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.cssSelector("[data-test=username]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test=password]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        WebElement heading = driver.findElement(By.cssSelector(".product_label"));
        assertEquals("Products", heading.getText());
    }
}
