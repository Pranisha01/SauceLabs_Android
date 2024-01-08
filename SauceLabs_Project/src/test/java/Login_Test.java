import Pages.HomePage;
import Pages.LoginPage;
import Pages.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Login_Test
{
    WebDriver driver;
    HomePage homepage;

    @BeforeMethod
    public void setup() throws MalformedURLException{
        driver = new Setup(driver).setupDeviceInNativeAppium();
        homepage = new HomePage(driver);
    }

    @Test
    public void login()
    {
        new LoginPage(driver).performLogin("standard_user","secret_sauce");
        boolean expected = new HomePage(driver).loginSuccessfull();
        Assert.assertEquals(expected,true);

    }

    @Test
    public void invalidLogin()
    {
        new LoginPage(driver).performLogin("locked_out_user","secret_sauce");
        Assert.assertTrue(new LoginPage(driver).errorDisplayCheck().isDisplayed());

    }



}
