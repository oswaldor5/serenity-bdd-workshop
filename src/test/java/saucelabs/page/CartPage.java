package saucelabs.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://www.saucedemo.com/v1/cart.html")
public class CartPage extends PageObject {
    @FindBy(className = "subheader")
    private WebElementFacade yourCartLabel;

    @FindBy(xpath = "//a[contains(@class,'checkout')]")
    private WebElementFacade checkoutButton;

    public String getHeader(){
        return yourCartLabel.getText();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }
}
