package saucelabs;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import saucelabs.actions.CheckOutActions;
import saucelabs.actions.LoginActions;
import saucelabs.model.SauceUser;

@ExtendWith(SerenityJUnit5Extension.class)
public class SauceDemoV1Test extends UIInteractionSteps {

    @Steps
    private LoginActions loginActions;
    private CheckOutActions checkOutActions;

    @ParameterizedTest
    @EnumSource(names = {"STANDARD_USER"})
    public void checkoutTest(SauceUser sauceUser) {
        loginActions.openLoginPage();
        loginActions.loginAs(sauceUser);

        // Add to random products to the cart, and navigate to checkout page
        checkOutActions.addProductToCart();
        /*checkOutActions.addProductToCart();
        checkOutActions.goToCheckOutPage();

        // Fill checkout information and finish checkout
        checkOutActions.fillCheckoutInfo("Yareli", "Macias","20200");*/
    }
}
