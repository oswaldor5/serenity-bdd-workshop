package saucelabs.actions;

import org.assertj.core.api.Assertions;
import saucelabs.page.LoginPage;
import saucelabs.model.SauceUser;
import saucelabs.page.ProductsPage;

public class LoginActions{
    LoginPage loginPage;
    ProductsPage productsPage;

    public void openLoginPage(){
        loginPage.open();
    }

    // Parameterized exercise
    public void loginAs(SauceUser user){
        loginPage.enterUserName(user.getUserName());
        loginPage.enterPsswd(user.getPassword());
        loginPage.clickLoginButton();
        Assertions.assertThat(productsPage.getHeader()).isEqualTo("Products");
    }

    public void verifyErrorMessage(String message){
        Assertions.assertThat(loginPage.getErrorMessage()).contains(message);
    }
}
