package saucelabs.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Random;

@DefaultUrl("https://www.saucedemo.com/v1/inventory.html")
public class ProductsPage extends PageObject {
    @FindBy(className = "product_label")
    private WebElementFacade productLabel;

    //@FindBy(xpath = "//button[contains(@class,'btn_inventory')]")
    //private List<WebElementFacade> productsAddToCartButtons;

    @FindBy(xpath = "(//button[contains(@class,'btn_primary')])[1]")
    private WebElementFacade productsAddToCartButtons;

    @FindBy(id = "shopping_cart_container")
    private WebElementFacade cartButton;

    public String getHeader(){
        return productLabel.getText();
    }

    public void clickProductAddToCartButton(){
        productsAddToCartButtons.click();
    }

    public void clickCartIcon(){
        cartButton.click();
    }
}
