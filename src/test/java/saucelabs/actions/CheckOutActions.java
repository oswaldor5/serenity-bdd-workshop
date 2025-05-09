package saucelabs.actions;

import org.assertj.core.api.Assertions;
import saucelabs.page.CartPage;
import saucelabs.page.CheckoutPage;
import saucelabs.page.ProductsPage;

public class CheckOutActions {
    CheckoutPage checkoutPage;
    ProductsPage productsPage;
    CartPage cartPage;

    public void addProductToCart(){
        productsPage.clickProductAddToCartButton();
    }

    public void goToCheckOutPage(){
        productsPage.clickCartIcon();
        Assertions.assertThat(cartPage.getHeader()).isEqualTo("Your Cart");
        cartPage.clickCheckoutButton();
        Assertions.assertThat(checkoutPage.getHeader()).isEqualTo("Checkout: Your Information");
    }

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
