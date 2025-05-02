package saucelabs.page;


import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://www.saucedemo.com/v1/")
public class LoginPage extends PageObject {
    @FindBy(id = "user-name")
    private WebElementFacade userNameInput;

    @FindBy(id = "password")
    private WebElementFacade psswdInput;

    @FindBy(id = "login-button")
    private WebElementFacade loginButton;

    @FindBy(className = "product_label")
    private WebElementFacade productLabel;

    public void enterUserName(String userName){
        userNameInput.type(userName);
    }

    public void enterPsswd(String psswd){
        psswdInput.type(psswd);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getHeader(){
        return productLabel.getText();
    }

}
