package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInfoPage {
    WebDriver driver;
    public CheckoutInfoPage(WebDriver driver){
        this.driver = driver;
    }
    private By firstname = AppiumBy.accessibilityId("test-First Name");
    private By lastname = AppiumBy.accessibilityId("test-Last Name");
    private By zipcode = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private By continueButton = AppiumBy.accessibilityId("test-CONTINUE");

    public CheckoutOverviewPage enterInformation(String firstName,String lastName,String zipCode){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(firstname));
        driver.findElement(firstname).sendKeys(firstName);
        driver.findElement(lastname).sendKeys(lastName);
        driver.findElement(zipcode).sendKeys(zipCode);
        driver.findElement(continueButton).click();
        return new CheckoutOverviewPage(driver);
    }
}
