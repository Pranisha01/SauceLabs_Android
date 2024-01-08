import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.Setup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddItemToCart_Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException
    {
        driver= new Setup(driver).setupDeviceInNativeAppium();
    }

    @Test
    public void addProductToCart() throws InterruptedException{
        HomePage homePageObj = new LoginPage(driver)
                .performLogin("standard_user", "secret_sauce");
        String homePageName = homePageObj.productName();
        String homePagePrice = homePageObj.productPrice();

        homePageObj.addProductToCart()
                .goToCartPage();
        String cartPageName = new CartPage(driver).productName();
        String cartPagePrice = new CartPage(driver).productPrice();

        Assert.assertEquals(homePageName,cartPageName);
        Assert.assertEquals(homePagePrice,cartPagePrice);
    }

    @AfterMethod
    public void EndSetup(){
        new Setup(driver).EndSetup();
    }
}
