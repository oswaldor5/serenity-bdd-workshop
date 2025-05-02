package saucelabs;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import saucelabs.actions.LoginActions;

@ExtendWith(SerenityJUnit5Extension.class)
public class SauceDemoTest {

    @Steps
    private LoginActions loginActions;

    @Test
    public void testApp() {
        loginActions.openLoginPage();
        loginActions.loginAs("standard_user","secret_sauce");

        loginActions.verifyPageHeader();
    }
}
