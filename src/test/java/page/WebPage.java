package page;
import org.openqa.selenium.By;

import static helper.utility.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class WebPage {
    By input_username = By.id("user-name");
    By input_password = By.id("password");
    By btn_login = By.id("login-button");
    By icon_cart = By.xpath("//a[@class=\"shopping_cart_link\"]");
    By icon_cart_item = By.xpath("//span[@class='shopping_cart_badge']");
    By addToCart = By.xpath("//*[text()=\"Add to cart\"][1]");
    By remove = By.xpath("//*[text()=\"Remove\"][1]");
    By btn_checkout = By.id("checkout");

    By txt_err_msg(String msg){
        return By.xpath("//*[contains(text(), '"+ msg +"')]");
    }


    public void openBrowser(){
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username){
        driver.findElement(input_username).sendKeys(username);
    }

    public void inputPassword(String pwd){
        driver.findElement(input_password).sendKeys(pwd);
    }

    public void clickButton(){
        driver.findElement(btn_login).click();
    }

    public void clickIcon(){
        driver.findElement(icon_cart).click();
    }

    public void verifyHomepage(){
        driver.findElement(icon_cart).isDisplayed();
    }

    public void verifyCartPage(){
        driver.findElement(btn_checkout).isDisplayed();
    }

    public void assertErrormsg(String errmsg){
        driver.findElement(txt_err_msg(errmsg)).isDisplayed();
    }

    public void clickAddtoCart(){
        driver.findElement(addToCart).click();
    }

    public void clickRemovetoCart(){
        driver.findElement(remove).click();
    }

    public void assertCartItem(String cartitem){
        String itemExpected = cartitem;
        String itemActual = driver.findElement(icon_cart_item).getText();
        assertThat(itemActual).isEqualTo(itemExpected);
    }


}
