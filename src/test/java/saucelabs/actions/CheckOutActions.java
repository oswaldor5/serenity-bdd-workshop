package saucelabs.actions;

import net.serenitybdd.annotations.Step;
import org.assertj.core.api.Assertions;
import saucelabs.page.CartPage;
import saucelabs.page.CheckoutPage;
import saucelabs.page.ProductsPage;

public class CheckOutActions {
    CheckoutPage checkoutPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Step("Add a product to the cart")
    public void addProductToCart(){
        productsPage.clickProductAddToCartButton();
    }

    @Step("Navigate to the Checkout page")
    public void goToCheckOutPage(){
        productsPage.clickCartIcon();
        Assertions.assertThat(cartPage.getHeader()).isEqualTo("Your Cart");
        cartPage.clickCheckoutButton();
        Assertions.assertThat(checkoutPage.getHeader()).isEqualTo("Checkout: Your Information");
    }

    @Step("Fill checkout with following data: {0} {1} {2}")
    public void fillCheckoutInfo(String firstName, String lastName, String postalCode){
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(postalCode);
        checkoutPage.clickContinueButton();
        Assertions.assertThat(cartPage.getHeader()).isEqualTo("Checkout: Overview");
        checkoutPage.clickFinishButton();
        Assertions.assertThat(cartPage.getHeader()).isEqualTo("Finish");
    }

}
