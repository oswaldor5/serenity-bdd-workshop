package saucelabs.actions;

import org.assertj.core.api.Assertions;
import saucelabs.page.LoginPage;

public class LoginActions{
    LoginPage loginPage;

    public void openLoginPage(){
        loginPage.open();
    }

    public void loginAs(String userName, String psswd){
        loginPage.enterUserName(userName);
        loginPage.enterPsswd(psswd);
        loginPage.clickLoginButton();
    }

    public void verifyPageHeader(){
        Assertions.assertThat(loginPage.getHeader()).isEqualTo("Products");
    }
}
