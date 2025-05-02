package saucelabs;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class SauceDemoV1Test extends UIInteractionSteps {

    @Managed
    private WebDriver driver;

    @Test
    public void testApp() {
        openUrl("https://www.saucedemo.com/v1/");
        $("[data-test=username]").type("standard_user");
        $("[data-test=password]").type("secret_sauce");
        $("#login-button").click();
        assertThat($(".product_label").getText()).isEqualTo("Products");
    }
}
