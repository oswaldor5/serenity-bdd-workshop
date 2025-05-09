package saucelabs.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://www.saucedemo.com/v1/checkout-step-one.html")
public class CheckoutPage extends PageObject {
    @FindBy(className = "subheader")
    private WebElementFacade checkoutLabel;

    @FindBy(id = "first-name")
    private WebElementFacade firstNameInput;

    @FindBy(id = "last-name")
    private WebElementFacade lastNameInput;

    @FindBy(id = "postal-code")
    private WebElementFacade postalCodeInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElementFacade continueButton;

    @FindBy(xpath = "//a[contains(@class,'btn_action')]")
    private WebElementFacade finishButton;

    public String getHeader(){
        checkoutLabel.waitUntilVisible();
        return checkoutLabel.getText();
    }

    public void enterFirstName(String firstName){
        firstNameInput.type(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.type(lastName);
    }

    public void enterPostalCode(String postalCode){
        postalCodeInput.type(postalCode);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickFinishButton(){
        finishButton.click();
    }
}
