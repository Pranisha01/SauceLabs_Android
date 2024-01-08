package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By productText = By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]\n");
    private By addToCartButton = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    private By cartButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    private By itemTitle = By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]");
    private By price = By.xpath("//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$29.99\"]");



    public HomePage addProductToCart(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(addToCartButton));
        driver.findElement(addToCartButton).click();
        return new HomePage(driver);
    }
    public CartPage goToCartPage() throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(cartButton));
        driver.findElement(cartButton).click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }


    public WebElement products (){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(productText));
        return driver.findElement(productText);
    }
    public String productName(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(itemTitle));
        return driver.findElement(itemTitle).getText();
    }
    public String productPrice(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(price));
        return driver.findElement(price).getText();
    }


    public boolean loginSuccessfull() {
       return driver.findElement(productText).isDisplayed();



    }
}
