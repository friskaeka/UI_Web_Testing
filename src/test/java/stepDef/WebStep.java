package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page.WebPage;

public class WebStep {

    WebPage webPage;

    public WebStep(){
        this.webPage = new WebPage();
    }

    @Given("Open Web login page")
    public void openWebLoginPage() {
        webPage.openBrowser();
    }

    @And("User Input Username {string}")
    public void userInputUsername(String username) {
        webPage.inputUsername(username);
    }

    @And("User Input Password {string}")
    public void userInputPassword(String pwd) {
        webPage.inputPassword(pwd);
    }

    @And("User Click Login Button")
    public void userClickLoginButton() {
        webPage.clickButton();
    }

    @And("User Will See Icon Chart in Homepage")
    public void userWillSeeIconChartInHomepage() {
        webPage.verifyHomepage();
    }

    @And("User Will See Error Message {string}")
    public void userWillSeeErrorMessage(String errmsg) {
        webPage.assertErrormsg(errmsg);
    }

    @And("User Add Item to Cart")
    public void userAddItemToCart() {
        webPage.clickAddtoCart();
    }

    @Then("Verify Cart Item Match {string}")
    public void verifyCartItemMatch(String cartitem) {
        webPage.assertCartItem(cartitem);
    }

    @And("User Remove Item To Cart")
    public void userRemoveItemToCart() {
        webPage.clickRemovetoCart();
    }

    @And("User Click Icon Cart")
    public void userClickIconCart() {
        webPage.clickIcon();
    }

    @Then("User Will See Button Checkout in your cart page")
    public void userWillSeeButtonCheckoutInYourCartPage() {
        webPage.verifyCartPage();
    }
}
