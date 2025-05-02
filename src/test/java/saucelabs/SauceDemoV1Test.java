package saucelabs;

import com.google.common.util.concurrent.Uninterruptibles;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SerenityJUnit5Extension.class)
public class SauceDemoV1Test extends UIInteractionSteps {

    @Managed
    private WebDriver driver;

    /*@BeforeEach
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
    }*/

    @Test
    public void testApp() {
        openUrl("https://www.saucedemo.com/v1/");
        // We can use $() or find()
        $("[data-test=username]").type("standard_user"); // type() makes sure to clear the field before typing
        $("[data-test=password]").type("secret_sauce");
        $("#login-button").click();
        assertThat(find(By.cssSelector(".product_label")).getText()).isEqualTo("Products");

        /*driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.cssSelector("[data-test=username]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test=password]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        WebElement heading = driver.findElement(By.cssSelector(".product_label"));
        assertEquals("Products", heading.getText());*/
    }
}
