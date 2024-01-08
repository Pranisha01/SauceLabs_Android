package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {
    WebDriver driver;
    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
    }
    private By finishButton = AppiumBy.accessibilityId("test-FINISH");
    private By titleShown = By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]");
    private By priceShown = By.xpath("//android.widget.TextView[@text=\"$29.99\"]");

    public CheckoutCompletePage finishOrder(){
        Action.MobileActions ma = new Action.MobileActions(driver);
        ma.scrollDownToSpecificText("FINISH");
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver);
    }

    public String productName(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(titleShown));
        return driver.findElement(titleShown).getText();
    }
    public String productPrice(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(priceShown));
        return driver.findElement(priceShown).getText();
    }
}
