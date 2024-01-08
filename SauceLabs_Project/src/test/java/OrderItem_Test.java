import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class OrderItem_Test {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException
    {
        driver= new Setup(driver).setupDeviceInNativeAppium();
    }

    @Test
    public void completeFlow() throws InterruptedException{
        new LoginPage(driver)
                .performLogin("standard_user", "secret_sauce")
                .addProductToCart()
                .goToCartPage();
        String cartPageName = new CartPage(driver).productName();
        String cartPagePrice = new CartPage(driver).productPrice();

        new CartPage(driver).pressCheckout()
                .enterInformation("Pranisha","Shahapure","416115");
        String overviewPageName = new CheckoutOverviewPage(driver).productName();
        String overviewPagePrice = new CheckoutOverviewPage(driver).productPrice();

        new CheckoutOverviewPage(driver).finishOrder();

        Assert.assertEquals(cartPageName,overviewPageName);
        Assert.assertEquals(cartPagePrice,overviewPagePrice);
    }

    @AfterMethod
    public void EndSetup(){
        new Setup(driver).EndSetup();
    }

}
