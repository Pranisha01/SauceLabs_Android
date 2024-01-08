package Pages;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
public class Setup {
    WebDriver driver;
    public Setup(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver setupDeviceInNativeAppium() throws MalformedURLException {
        String AppName = System.getProperty("user.dir") + "/src/test/resources/TestDataFiles/Android.SauceLabs.Mobile.Sample.app.2.2.0.apk";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Demo1");
        caps.setCapability("appium:app", AppName);
        caps.setCapability("appium:platformVersion", "14.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appWaitActivity", "*");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        return driver;
    }
    public void EndSetup()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }
}