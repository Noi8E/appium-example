package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.SelenoidConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static drivers.RealMobileDriver.getAppiumUrl;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelenoidMobileDriver implements WebDriverProvider {

    static SelenoidConfig selenoidConfig = ConfigFactory.create(SelenoidConfig.class, System.getProperties());

    static String url = selenoidConfig.url();
    static String user = selenoidConfig.user();
    static String password = selenoidConfig.password();
    static String platform = selenoidConfig.platformName();
    static String deviceName = selenoidConfig.deviceName();
    static String version = selenoidConfig.version();
    static String locale = selenoidConfig.locale();
    static String language = selenoidConfig.language();
    static String appPackage = selenoidConfig.appPackage();
    static String appActivity = selenoidConfig.appActivity();

    public static URL getAppiumUrl() {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", platform);
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("version", version);
        desiredCapabilities.setCapability("locale", locale);
        desiredCapabilities.setCapability("language", language);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("app", getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));

        return new AndroidDriver(getAppiumUrl(), desiredCapabilities);
    }


    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");
        return file.getAbsolutePath();
    }
}
