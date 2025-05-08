package saucelabs.actions;

import org.assertj.core.api.Assertions;
import saucelabs.page.LoginPage;
import saucelabs.model.SauceUser;

public class LoginActions{
    LoginPage loginPage;

    public void openLoginPage(){
        loginPage.open();
    }

    /*public void loginAs(String userName, String psswrd){
        loginPage.enterUserName(userName);
        loginPage.enterPsswd(psswrd);
        loginPage.clickLoginButton();
    }*/

    // Parameterized exercise
    public void loginAs(SauceUser user){
        loginPage.enterUserName(user.getUserName());
        loginPage.enterPsswd(user.getPassword());
        loginPage.clickLoginButton();
    }

    public void verifyPageHeader(){
        Assertions.assertThat(loginPage.getHeader()).isEqualTo("Products");
    }

    public void verifyErrorMessage(String message){
        Assertions.assertThat(loginPage.getErrorMessage()).contains(message);
    }
}
